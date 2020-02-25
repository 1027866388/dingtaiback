package com.dingtai.customermager.dao;

import com.dingtai.customermager.entity.request.GetUserListReq;
import com.dingtai.customermager.entity.response.GetUserListResp;
import com.dingtai.customermager.entity.db.UserEntity;
import com.dingtai.customermager.entity.request.UpdatePwdReq;
import com.dingtai.customermager.entity.request.UpdateUserReq;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户信息Mapper
 *
 * @author wangyanhui
 * @date 2018-03-19 20:15
 */
@Repository
public interface UserInfoMapper {
    /**
     * 获取用户信息列表
     *
     * @param request 请求实体
     * @return 分页用户列表
     */
    Page<GetUserListResp> listUserInfo(GetUserListReq request);

    /**
     * 查询用户的所有权限标识
     *
     * @param userId 用户ID
     * @return 权限标识列表
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有权限Id
     *
     * @param userId 用户ID
     * @return 权限标识列表
     */
    List<Long> queryAllPermissionId(Long userId);

    /**
     * 根据用户名查询系统用户
     *
     * @param userName 用户名
     * @return 用户信息
     */
    List<UserEntity> queryByUserName(String userName);

    /**
     * 通过邮箱查询
     *
     * @param email 邮箱
     * @return 用户信息
     */
    List<UserEntity> queryByEmail(String email);


    /**
     * 根据真实姓名查询系统用户
     *
     * @param realName 用户名
     * @return 用户信息
     */
    List<UserEntity> queryByRealName(String realName);


    /**
     * 根据用户id查询用户信息
     *
     * @param userId 用户id
     * @return 用户信息
     */
    GetUserListResp getUserByUserId(Long userId);

    /**
     * 根据用户OA id查询用户信息
     *
     * @param oaId OA id
     * @return 用户信息
     */
    UserEntity getUserByOaId(String oaId);

    /**
     * 新增用户
     *
     * @param req 请求实体
     * @return 影响行数
     */
    Integer addUser(UserEntity req);

    /**
     * 更新用户
     *
     * @param req 请求实体
     * @return 影响行数
     */
    Integer updateUser(UpdateUserReq req);

    /**
     * 锁定用户
     *
     * @param userId 用户id
     * @return 影响行数
     */
    Integer lockUser(Long userId);

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return 影响行数
     */
    Integer deleteUser(Long userId);

    /**
     * 批量删除用户
     *
     * @param userIds 用户id
     * @return 影响行数
     */
    Integer batchDeleteUser(List<Long> userIds);

    /**
     * 修改密码
     *
     * @param updatePwdReq 请求实体
     * @return 影响行数
     */
    Integer updatePassword(UpdatePwdReq updatePwdReq);


    /**
     * 重置密码
     *
     * @param updatePwdReq 请求实体
     * @return 影响行数
     */
    Integer resetPassword(UpdatePwdReq updatePwdReq);

    /**
     * 初始化密码
     *
     * @param userEntity 请求实体
     * @return 影响行数
     */
    Integer initPassword(UserEntity userEntity);

    /**
     * 查询用户OA
     *
     * @param id 用户ID
     * @return
     */
    String selectOaId(Long id);

    /**
     * 解锁用户
     *
     * @return 影响行数
     */
    Integer unLockUser();
}
