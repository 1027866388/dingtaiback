package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.entity.request.AddUserReq;
import com.dingtai.customermager.entity.request.GetUserListReq;
import com.dingtai.customermager.entity.request.UpdatePwdReq;
import com.dingtai.customermager.entity.request.UpdateUserReq;
import com.dingtai.customermager.entity.response.GetUserListResp;
import com.dingtai.customermager.service.PermissionService;
import com.dingtai.customermager.service.UserService;
import com.dingtai.customermager.dao.RoleEntityMapper;
import com.dingtai.customermager.dao.UserEntityMapper;
import com.dingtai.customermager.dao.UserInfoMapper;
import com.dingtai.customermager.dao.UserRoleInfoMapper;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.db.RoleEntity;
import com.dingtai.customermager.entity.db.UserEntity;
import com.dingtai.customermager.entity.db.UserRoleEntity;
import com.dingtai.customermager.enums.ResultCodeEnum;
import com.dingtai.customermager.exceptions.TransactionException;
import com.dingtai.customermager.utils.AesUtil;
import com.dingtai.customermager.utils.LogUtil;
import com.dingtai.customermager.utils.ShiroUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户接口实现
 *
 * @author wangyanhui
 * @date 2018-03-19 19:53
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 日志
     */
    private static Logger log = LogUtil.get();

    /**
     * 用户Mapper
     */
    @Autowired
    private UserInfoMapper userInfoMapper;


    /**
     * 用户角色Mapper
     */
    @Autowired
    private UserRoleInfoMapper userRoleInfoMapper;

    /**
     * 角色实体Mapper
     */
    @Autowired
    private RoleEntityMapper roleEntityMapper;

    /**
     * 用户实体Mapper
     */
    @Autowired
    private UserEntityMapper userEntityMapper;

    @Value("${AppKey.originPassword}")
    private String originPassword;

    @Value("${AppKey.passwordAesKey}")
    private String passwordAesKey;

    @Value("${AppKey.phoneAesKey}")
    private String phoneAesKey;


    @Value("${spring.profiles.active}")
    private String avtive;
    @Autowired
    private PermissionService permissionService;
    /**
     * token有效时间，30分钟
     */
    private final static long TOKEN_SECONDS = 30 * 60;

    /**
     * 获取用户列表信息
     *
     * @param request 请求实体
     * @return 用户列表实体
     */
    @Override
    public Result<PageInfo<GetUserListResp>> listUserInfo(GetUserListReq request) {
        Result result;
        PageHelper.startPage(request.getPageCurrent(), request.getPageSize());
        Page<GetUserListResp> listUserInfo = userInfoMapper.listUserInfo(request);
        Long perm = 50L;
        boolean canEdit = permissionService.hasPerMission(perm);
        perm = 51L;
        boolean canDelete = permissionService.hasPerMission(perm);
        if (listUserInfo != null) {
            if (listUserInfo.getResult() != null) {
                for (GetUserListResp resp : listUserInfo.getResult()) {
                    String mobile = AesUtil.decrypt(resp.getMobile(), phoneAesKey, 0);
                    if (mobile != null && mobile.length() == 11) {
                        String phoneNumber = mobile.substring(0, 3) + "****" + mobile.substring(7, mobile.length());
                        resp.setMobile(phoneNumber);
                    } else {
                        mobile = resp.getMobile();
                        if (mobile != null && mobile.length() == 11) {
                            String phoneNumber = mobile.substring(0, 3) + "****" + mobile.substring(7, mobile.length());
                            resp.setMobile(phoneNumber);
                        }

                    }
                    resp.setCanEdit(canEdit);
                    resp.setCanDelete(canDelete);
                }
            }
            PageInfo<GetUserListResp> userListPageInfo = new PageInfo(listUserInfo);

            result = new Result(userListPageInfo);
        } else {
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, "查询数据为空！");
        }
        return result;
    }

    /**
     * 根据用户id获取用户
     *
     * @param userId 用户id
     * @return 用户实体
     */
    @Override
    public Result<GetUserListResp> getUserByUserId(Long userId) {
        Result result;
        GetUserListResp userInfo = userInfoMapper.getUserByUserId(userId);
        if (userInfo != null) {
            String mobile = AesUtil.decrypt(userInfo.getMobile(), phoneAesKey, 0);
            if (mobile != null) {
                userInfo.setMobile(mobile);
            }
            result = new Result(userInfo);
        } else {
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, "查询数据为空！");
        }
        return result;
    }

    /**
     * 新增用户
     *
     * @param addUserReq 请求实体
     * @return Result实体
     */
    @Override
    public Result addUser(AddUserReq addUserReq) {
        Result result;
        //用户名
        String userName = addUserReq.getUserName();
        List<UserEntity> userEntitys = userInfoMapper.queryByUserName(userName);
        if (userEntitys != null && userEntitys.size() > 0) {
            return new Result(ResultCodeEnum.APPEND_DATA_ERROR, "当前用户已经存在!");
        }
        String realName = addUserReq.getRealName();
        userEntitys = userInfoMapper.queryByRealName(realName);
        if (userEntitys != null && userEntitys.size() > 0) {
            return new Result(ResultCodeEnum.APPEND_DATA_ERROR, "当前姓名已经存在");
        }
        userEntitys = userInfoMapper.queryByEmail(addUserReq.getEmail());
        if (userEntitys != null && userEntitys.size() > 0) {
            return new Result(ResultCodeEnum.APPEND_DATA_ERROR, "当前邮箱已经存在");
        }
        //region 新增用户
        //原密码
        String pwd = addUserReq.getPassword();
        //加密后密码
        String encryptPwd = AesUtil.getAesAndMd5Str(pwd, passwordAesKey);
        addUserReq.setPassword(encryptPwd);
        UserEntity addUserEntity = new UserEntity();
        addUserEntity.setUserName(addUserReq.getUserName());
        addUserEntity.setPassword(addUserReq.getPassword());
        addUserEntity.setEmail(addUserReq.getEmail());
        String mobileEnc = AesUtil.encrypt(addUserReq.getMobile(), phoneAesKey, 0);
        addUserEntity.setMobile(mobileEnc);
        addUserEntity.setRealName(addUserReq.getRealName());
        addUserEntity.setCreateTime(new Date());
        addUserEntity.setModifyTime(new Date());
        addUserEntity.setCreator(ShiroUtils.getUserId());
        addUserEntity.setModifier(ShiroUtils.getUserId());
        addUserEntity.setOrgId(addUserReq.getOrgId());
        Integer addUser = userInfoMapper.addUser(addUserEntity);
        if (addUser <= 0) {
            throw new TransactionException(ResultCodeEnum.APPEND_DATA_ERROR, "新增用户表失败！");
        }
        //endregion
        //region 新增用户角色
        for (Long roleId : addUserReq.getRoleId()) {
            if (roleId <= 0) {
                throw new TransactionException(ResultCodeEnum.APPEND_DATA_ERROR, "角色id不合法！");
            }
        }
        for (Long roleId : addUserReq.getRoleId()) {
            UserRoleEntity userRoleEntity = new UserRoleEntity();
            //新增返回的主键id
            userRoleEntity.setUserId(addUserEntity.getId());
            userRoleEntity.setRoleId(roleId);
            Integer addUserRole = userRoleInfoMapper.addUserRole(userRoleEntity);
            if (addUserRole <= 0) {
                throw new TransactionException(ResultCodeEnum.APPEND_DATA_ERROR, "新增用户角色表失败！");
            }
        }
        result = new Result();
        return result;
    }

    /**
     * 更新用户
     *
     * @param req 请求实体
     * @return Result实体
     */
    @Override
    public Result updateUser(UpdateUserReq req) {
        String mobileEnc = AesUtil.encrypt(req.getMobile(), phoneAesKey, 0);
        if (mobileEnc != null) {
            req.setMobile(mobileEnc);
        }

        Result result;
        //判断用户是否存在
        GetUserListResp userInfo = userInfoMapper.getUserByUserId(req.getUserId());
        if (userInfo == null) {
            return new Result(ResultCodeEnum.QUERY_DATA_ERROR, "需要更新的用户不存在!");
        }
        //要更新姓名，且新的姓名已经存在
        List<UserEntity> userEntitys = userInfoMapper.queryByRealName(req.getRealName());
        if (!userInfo.getRealName().equals(req.getRealName()) && userEntitys != null && userEntitys.size() > 0) {
            return new Result(ResultCodeEnum.APPEND_DATA_ERROR, "当前姓名已经存在");
        }
        //要更新邮箱，且新的邮箱已经存在
        userEntitys = userInfoMapper.queryByEmail(req.getEmail());
        if (!userInfo.getEmail().equals(req.getEmail()) && userEntitys != null && userEntitys.size() > 0) {
            return new Result(ResultCodeEnum.APPEND_DATA_ERROR, "当前邮箱已经存在");
        }
        //region 更新用户
        Integer updateUser = userInfoMapper.updateUser(req);
        if (updateUser <= 0) {
            throw new TransactionException(ResultCodeEnum.MODIFY_DATA_ERROR, "更新用户表失败！");
        }
        //endregion
        //region 更新用户角色表
        //检查用户是否被赋予角色
        if (userRoleInfoMapper.checkUserHasRole(req.getUserId()) > 0) {
            Integer delete = userRoleInfoMapper.deleteUserRole(req.getUserId());
            if (delete <= 0) {
                throw new TransactionException(ResultCodeEnum.DELETE_DATA_ERROR, "删除用户角色表失败！");
            }
        }
        //定义用户角色实体
        for (Long roleId : req.getRoleId()) {
            if (roleId <= 0) {
                throw new TransactionException(ResultCodeEnum.APPEND_DATA_ERROR, "角色id不合法！");
            }
        }

        for (Long roleId : req.getRoleId()) {
            RoleEntity roleEntity = roleEntityMapper.selectByPrimaryKey(roleId);
            if (roleEntity == null) {
                throw new TransactionException(ResultCodeEnum.MODIFY_DATA_ERROR, "当前角色id对应的角色不存在！");
            }
        }

        for (Long roleId : req.getRoleId()) {
            UserRoleEntity userRoleEntity = new UserRoleEntity();
            //新增返回的主键id
            userRoleEntity.setUserId(req.getUserId());
            userRoleEntity.setRoleId(roleId);
            Integer addUserRole = userRoleInfoMapper.addUserRole(userRoleEntity);
            if (addUserRole <= 0) {
                throw new TransactionException(ResultCodeEnum.APPEND_DATA_ERROR, "新增用户角色表失败！");
            }
        }
        //endregion
        result = new Result();
        return result;
    }

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return Result实体
     */
    @Override
    public Result deleteUser(Long userId) {
        Result result = new Result();
        //判断用户是否存在
        GetUserListResp userInfo = userInfoMapper.getUserByUserId(userId);
        if (userInfo == null) {
            return new Result(ResultCodeEnum.QUERY_DATA_ERROR, "需要删除的用户不存在!");
        }
        //region 删除用户表
        Integer deleteUser = userInfoMapper.deleteUser(userId);
        if (deleteUser <= 0) {
            throw new TransactionException(ResultCodeEnum.DELETE_DATA_ERROR, "删除用户表失败！");
        }
        //endregion
        //region 删除用户角色表
        //检查用户是否被赋予角色
        if (userRoleInfoMapper.checkUserHasRole(userId) > 0) {
            Integer deleteUserRole = userRoleInfoMapper.deleteUserRole(userId);
            if (deleteUserRole <= 0) {
                throw new TransactionException(ResultCodeEnum.DELETE_DATA_ERROR, "删除用户角色表失败！");
            }
        }
        //endregion
        return result;
    }


    /**
     * 修改密码
     *
     * @param updatePwdReq 请求实体
     * @return Result实体
     */
    @Override
    public Result updatePassword(UpdatePwdReq updatePwdReq) {
        Result result = new Result();
        //sha256加密
        updatePwdReq.setOldPassword(AesUtil.getAesAndMd5Str(updatePwdReq.getOldPassword(), passwordAesKey));
        updatePwdReq.setNewPassword(AesUtil.getAesAndMd5Str(updatePwdReq.getNewPassword(), passwordAesKey));
        Integer updatePassword = userInfoMapper.updatePassword(updatePwdReq);
        if (updatePassword == 0) {
            throw new TransactionException(ResultCodeEnum.MODIFY_DATA_ERROR, "原密码不正确！");
        } else if (updatePassword != 1) {
            throw new TransactionException(ResultCodeEnum.MODIFY_DATA_ERROR, "修改密码失败！");
        }
        return result;
    }


    /**
     * 更新最后登录时间
     *
     * @param userId 用户id
     * @return 影响行数
     */
    @Override
    public Integer updateLastLoginTime(Long userId) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        userEntity.setLastLoginTime(new Date());
        return userEntityMapper.updateByPrimaryKeySelective(userEntity);
    }

    /**
     * 根据用户获取所有的权限标识
     *
     * @param userId 用户id
     * @return 权限标识列表
     */
    @Override
    public List<String> queryAllPerms(Long userId) {
        return userInfoMapper.queryAllPerms(userId);
    }

    /**
     * 通过用户名获取用户信息
     *
     * @param userName 用户名
     * @return 用户信息
     */
    @Override
    public List<UserEntity> queryByUserName(String userName) {
        return userInfoMapper.queryByUserName(userName);
    }

    /**
     * 根据用户获取所有的权限Id
     *
     * @param userId 用户id
     * @return 权限id列表
     */
    @Override
    public List<Long> queryAllPermissionId(Long userId) {
        return userInfoMapper.queryAllPermissionId(userId);
    }


}
