package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.request.AddUserReq;
import com.dingtai.customermager.entity.request.GetUserListReq;
import com.dingtai.customermager.entity.request.UpdatePwdReq;
import com.dingtai.customermager.entity.request.UpdateUserReq;
import com.dingtai.customermager.entity.response.GetUserListResp;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.db.UserEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 用户接口
 *
 * @author wangyanhui
 * @date 2018-03-19 19:47
 */
public interface UserService {
    /**
     * 获取用户列表信息
     *
     * @param request 请求实体
     * @return 用户列表实体
     */
    Result<PageInfo<GetUserListResp>> listUserInfo(GetUserListReq request);

    /**
     * 根据用户id获取用户
     *
     * @param userId 用户id
     * @return 用户实体
     */
    Result<GetUserListResp> getUserByUserId(Long userId);

    /**
     * 新增用户
     *
     * @param req 请求实体
     * @return Result实体
     */
    Result addUser(AddUserReq req);

    /**
     * 更新用户
     *
     * @param req 请求实体
     * @return Result实体
     */
    Result updateUser(UpdateUserReq req);

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return Result实体
     */
    Result deleteUser(Long userId);


    /**
     * 修改密码
     *
     * @param updatePwdReq 请求实体
     * @return Result实体
     */
    Result updatePassword(UpdatePwdReq updatePwdReq);



    /**
     * 更新最后登录时间
     *
     * @param userId 用户id
     * @return 影响行数
     */
    Integer updateLastLoginTime(Long userId);

    /**
     * 根据用户获取所有的权限标识
     *
     * @param userId 用户id
     * @return 权限标识列表
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 通过用户名获取用户信息
     *
     * @param userName 用户名
     * @return 用户信息
     */
    List<UserEntity> queryByUserName(String userName);


    /**
     * 根据用户获取所有的权限Id
     *
     * @param userId 用户id
     * @return 权限id列表
     */
    List<Long> queryAllPermissionId(Long userId);


}
