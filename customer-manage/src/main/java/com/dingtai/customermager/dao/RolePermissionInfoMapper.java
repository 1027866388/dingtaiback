package com.dingtai.customermager.dao;

import com.dingtai.customermager.entity.db.RolePermissionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色权限信息Mapper
 *
 * @author wangyanhui
 * @date 2018-04-12 16:56
 */
@Repository
public interface RolePermissionInfoMapper {
    /**
     * 删除角色权限
     *
     * @param roleId 角色id
     * @return 影响行数
     */
    int deleteByRoleId(Long roleId);

    /**
     * 获取角色权限信息
     *
     * @param roleId 角色id
     * @return 列表
     */
    List<RolePermissionEntity> selectByRoleId(Long roleId);

    /**
     * 通过角色id获取权限id列表
     *
     * @param roleId 角色id
     * @return 权限id列表
     */
    List<Long> selectPermissionIdByRoleId(Long roleId);
}
