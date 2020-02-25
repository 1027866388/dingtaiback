package com.dingtai.customermager.service.impl;
import com.dingtai.customermager.constants.PermissionConstant;
import com.dingtai.customermager.dao.*;
import com.dingtai.customermager.entity.response.GetRoleListResp;
import com.dingtai.customermager.service.PermissionService;
import com.dingtai.customermager.service.RoleService;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.db.RoleEntity;
import com.dingtai.customermager.entity.db.RolePermissionEntity;
import com.dingtai.customermager.entity.request.AddRoleReq;
import com.dingtai.customermager.entity.request.GetRoleListReq;
import com.dingtai.customermager.entity.request.UpdateRoleReq;
import com.dingtai.customermager.entity.response.GetRoleInfoResp;
import com.dingtai.customermager.enums.ResultCodeEnum;
import com.dingtai.customermager.exceptions.TransactionException;
import com.dingtai.customermager.utils.LogUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 角色接口实现
 *
 * @author wangyanhui
 * @date 2018-04-10 20:52
 */
@Service
public class RoleServiceImpl implements RoleService {
    /**
     * 日志
     */
    private static Logger log = LogUtil.get();
    @Autowired
    private PermissionService permissionService;

    /**
     * 角色信息Mapper
     */
    @Autowired
    private RoleInfoMapper roleInfoMapper;


    /**
     * 角色实体Mapper
     */
    @Autowired
    private RoleEntityMapper roleEntityMapper;

    /**
     * 角色权限Mapper
     */
    @Autowired
    private RolePermissionEntityMapper rolePermissionEntityMapper;

    /**
     * 角色权限Mapper
     */
    @Autowired
    private RolePermissionInfoMapper rolePermissionInfoMapper;

    /**
     * 用户角色Mapper
     */
    @Autowired
    private UserRoleInfoMapper userRoleInfoMapper;

    /**
     * 获取角色列表信息
     *
     * @param request 请求实体
     * @return 角色列表实体
     */
    @Override

    public Result<PageInfo<GetRoleListResp>> listRoleInfo(GetRoleListReq request) {
        Result result;
        PageHelper.startPage(request.getPageCurrent(), request.getPageSize());
        Page<GetRoleListResp> listRoleInfo = roleInfoMapper.listRoleInfo(request);
        if (listRoleInfo != null) {
            PageInfo<GetRoleListResp> roleListPageInfo = new PageInfo(listRoleInfo);
            Long perm = 53L;
            boolean canEdit = permissionService.hasPerMission(perm);
            perm = 54L;
            boolean canDelete = permissionService.hasPerMission(perm);
            if (listRoleInfo.getResult() != null) {
                for (GetRoleListResp item : listRoleInfo.getResult()) {
                    item.setCanDelete(canDelete);
                    item.setCanEdit(canEdit);
                }
            }
            result = new Result(roleListPageInfo);
        } else {
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, "查询数据为空！");
        }
        return result;
    }

    /**
     * 通过角色id获取角色信息
     *
     * @param roleId 角色id
     * @return 角色信息
     */
    @Override
    public Result<GetRoleInfoResp> getRoleInfoByRoleId(Long roleId) {
        RoleEntity roleEntity = roleEntityMapper.selectByPrimaryKey(roleId);
        if (roleEntity == null) {
            log.warn("未查询到角色信息", roleId);
            return new Result(ResultCodeEnum.QUERY_DATA_ERROR, "未查询到数据");
        }
        //获取权限id列表
        List<Long> permissionIds = rolePermissionInfoMapper.selectPermissionIdByRoleId(roleId);
        GetRoleInfoResp getRoleInfo = new GetRoleInfoResp();
        getRoleInfo.setRoleName(roleEntity.getRoleName());
        getRoleInfo.setRoleDesc(roleEntity.getRoleDesc());
        getRoleInfo.setPermissionIdList(permissionIds);
        return new Result(getRoleInfo);
    }

    /**
     * 删除角色
     *
     * @param roleId 角色id
     * @return result实体
     */
    @Override
    public Result deleteRole(Long roleId) {
        Result result = new Result();
        RoleEntity roleEntity = roleEntityMapper.selectByPrimaryKey(roleId);
        if (roleEntity == null) {
            log.warn("需要删除的角色不存在!");
            return new Result(ResultCodeEnum.QUERY_DATA_ERROR, "需要删除的角色不存在!");
        }
        if (PermissionConstant.SUPER_ADMIN_ROLE_NAME.equals(roleEntity.getRoleName())) {
            log.warn("超级管理员的角色不可以删除!");
            return new Result(ResultCodeEnum.DELETE_DATA_ERROR, "超级管理员的角色不可以删除！");
        }
        if (userRoleInfoMapper.checkRoleHasUsed(roleId) > 0) {
            log.warn("有用户正在使用该角色不能删除!");
            return new Result(ResultCodeEnum.DELETE_DATA_ERROR, "有用户正在使用该角色不能删除!");
        }
        int deleteByRoleId = roleEntityMapper.deleteByPrimaryKey(roleId);
        if (deleteByRoleId <= 0) {
            throw new TransactionException(ResultCodeEnum.DELETE_DATA_ERROR, "删除角色失败");
        }
        return result;
    }

    /**
     * 新增角色
     *
     * @param request 请求实体
     * @return result实体
     */
    @Override
    public Result addRole(AddRoleReq request, Long userId) {
        Result result = new Result();
        //判断需要新增的角色是否存在
        if (roleInfoMapper.checkAddRoleName(request.getRoleName().trim()) > 0) {
            log.warn("角色已存在！");
            return new Result(ResultCodeEnum.QUERY_DATA_ERROR, "角色已存在!");
        }
        //region 新增角色
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName(request.getRoleName());
        roleEntity.setRoleDesc(request.getRoleDesc());
        roleEntity.setCreator(userId);
        roleEntity.setCreateTime(new Date());
        roleEntity.setModifyTime(new Date());
        int addRole = roleInfoMapper.addRole(roleEntity);
        if (addRole <= 0) {
            throw new TransactionException(ResultCodeEnum.APPEND_DATA_ERROR, "新增角色表失败！");
        }
        //endregion
        //新增角色权限关系
        addRolePermission(request.getPermissionIds(), roleEntity.getId());
        return result;
    }

    /**
     * 更新角色
     *
     * @param request 请求实体
     * @return result实体
     */
    @Override
    public Result updateRole(UpdateRoleReq request) {
        Result result = new Result();
        RoleEntity roleEntity = roleEntityMapper.selectByPrimaryKey(request.getRoleId());
        if (roleEntity == null) {
            log.warn("需要修改的角色不存在!");
            return new Result<>(ResultCodeEnum.QUERY_DATA_ERROR, "需要修改的角色不存在!");
        }
        if (PermissionConstant.SUPER_ADMIN_ROLE_NAME.equals(roleEntity.getRoleName())) {
            log.warn("超级管理员的角色不可以修改！");
            return new Result<>(ResultCodeEnum.MODIFY_DATA_ERROR, "超级管理员的角色不可以修改！");
        }
        //判断修改的角色名称是否存在
        if (roleInfoMapper.checkUpdateRoleName(request) > 0) {
            log.warn("角色已存在！");
            return new Result(ResultCodeEnum.QUERY_DATA_ERROR, "角色已存在！");
        }
        //region 更新角色表
        RoleEntity updateRoleEntity = new RoleEntity();
        updateRoleEntity.setRoleName(request.getRoleName());
        updateRoleEntity.setRoleDesc(request.getRoleDesc());
        updateRoleEntity.setId(request.getRoleId());
        int updateRole = roleEntityMapper.updateByPrimaryKeySelective(updateRoleEntity);
        if (updateRole <= 0) {
            throw new TransactionException(ResultCodeEnum.MODIFY_DATA_ERROR, "更新角色表失败！");
        }
        //endregion
        //region 更新角色权限表
        //删除角色权限表，再新增
        int delete = rolePermissionInfoMapper.deleteByRoleId(request.getRoleId());
        log.info("删除角色权限数量" + delete);
        //新增角色权限关系
        addRolePermission(request.getPermissionIds(), request.getRoleId());
        //endregion
        return result;
    }

    /**
     * 根据角色查询出对应的人员信息
     *
     * @param roleName 角色名称
     * @return
     */
    @Override
    public Result selectUserNameByRole(String roleName) {
        List<Map<String, Object>> userEntityList = userRoleInfoMapper.selectUserNameByRole(roleName);
        return new Result(userEntityList);
    }

    /**
     * 根据地市和角色获取资料上传人
     *
     * @param orgCode  地市
     * @param roleName 角色
     * @return
     */
    @Override
    public List<Map<String, Object>> selectPersonByCityCode(String orgCode, String roleName) {

        List<Map<String, Object>> result = userRoleInfoMapper.selectPersonByCityCode(orgCode, roleName);

        return result;
    }

    /**
     * 新增角色权限表
     *
     * @param permissionIds 权限id列表
     * @param roleId        角色id
     * @throws Exception 异常
     */
    public void addRolePermission(List<Long> permissionIds, long roleId) {
        if (permissionIds != null && !permissionIds.isEmpty()) {
            for (Long permissionId : permissionIds) {
                if (permissionId > 0) {
                    RolePermissionEntity rolePermissionEntity = new RolePermissionEntity();
                    rolePermissionEntity.setRoleId(roleId);
                    rolePermissionEntity.setPermissionId(permissionId);
                    int insertSelective = rolePermissionEntityMapper.insertSelective(rolePermissionEntity);
                    if (insertSelective <= 0) {
                        throw new TransactionException(ResultCodeEnum.APPEND_DATA_ERROR, "新增角色权限关系失败！");
                    }
                }
            }
        }
    }
}
