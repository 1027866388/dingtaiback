package com.dingtai.customermager.dao;

import com.dingtai.customermager.entity.request.GetRoleListReq;
import com.dingtai.customermager.entity.response.GetRoleListResp;
import com.dingtai.customermager.entity.db.RoleEntity;
import com.dingtai.customermager.entity.request.UpdateRoleReq;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

/**
 * 角色信息Mapper
 *
 * @author wangyanhui
 * @date 2018-04-10 20:58
 */
@Repository
public interface RoleInfoMapper {
    /**
     * 获取角色信息列表
     *
     * @param request 请求实体
     * @return 分页角色列表
     */
    Page<GetRoleListResp> listRoleInfo(GetRoleListReq request);

    /**
     * 检查角色名称是否存在（新增）
     *
     * @param roleName 角色名称
     * @return 影响行数
     */
    int checkAddRoleName(String roleName);

    /**
     * 检查角色名称是否存在（更新）
     *
     * @param request 请求实体
     * @return 影响行数
     */
    int checkUpdateRoleName(UpdateRoleReq request);

    /**
     * 新增角色
     *
     * @param roleEntity 角色实体
     * @return 影响行数
     */
    int addRole(RoleEntity roleEntity);
}
