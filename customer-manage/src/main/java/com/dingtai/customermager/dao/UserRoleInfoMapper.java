package com.dingtai.customermager.dao;


import com.dingtai.customermager.entity.db.UserRoleEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 用户角色信息Mapper
 *
 * @author wangyanhui
 * @date 2018-03-19 20:15
 */
@Repository
public interface UserRoleInfoMapper {
    /**
     * 新增用户角色
     *
     * @param req 请求实体
     * @return 影响行数
     */
    Integer addUserRole(UserRoleEntity req);

    /**
     * 删除用户角色
     *
     * @param userId 用户id
     * @return 影响行数
     */
    Integer deleteUserRole(Long userId);

    /**
     * 批量删除用户
     *
     * @param userIds 用户id
     * @return 影响行数
     */
    Integer batchDeleteUserRole(List<Long> userIds);

    /**
     * 检查角色是否被使用
     *
     * @param roleId 角色id
     * @return 影响行数
     */
    Integer checkRoleHasUsed(Long roleId);

    /**
     * 检查用户是否被赋予角色
     *
     * @param userId 用户id
     * @return 影响行数
     */
    Integer checkUserHasRole(Long userId);

    /**
     * 根据角色查询出对应的人员信息
     *
     * @param roleName 角色名称
     * @return
     */
    List<Map<String, Object>> selectUserNameByRole(String roleName);

    /**
     * 根据角色查询人员明细
     *
     * @param roleName 角色名称
     * @return
     */
    List<Map<String, Object>> selectUserInfoByRole(String roleName);

    /**
     * 根据角色和地市获取人员信息
     *
     * @param orgCode  地市
     * @param roleName 角色
     * @return
     */
    List<Map<String, Object>> selectPersonByCityCode(@Param("orgCode") String orgCode, @Param("roleName") String roleName);

    /**
     * 根据用户ID查询用户角色名称
     *
     * @param userId 用户ID
     * @return 用户角色名称
     */
    List<String> getUserRoleNameByUserId(@Param("userId") Long userId);

}