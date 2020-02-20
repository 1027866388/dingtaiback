package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.response.GetRoleListResp;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.AddRoleReq;
import com.dingtai.customermager.entity.request.GetRoleListReq;
import com.dingtai.customermager.entity.request.UpdateRoleReq;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 角色接口
 *
 * @author wangyanhui
 * @date 2018-04-10 20:50
 */
public interface RoleService {
    /**
     * 获取角色列表信息
     *
     * @param request 请求实体
     * @return 角色列表实体
     */
    Result<PageInfo<GetRoleListResp>> listRoleInfo(GetRoleListReq request);

    /**
     * 通过角色id获取角色信息
     *
     * @param roleId 角色id
     * @return 角色信息
     */
    Result getRoleInfoByRoleId(Long roleId);

    /**
     * 删除角色
     *
     * @param roleId 角色id
     * @return result实体
     */
    Result deleteRole(Long roleId);

    /**
     * 新增角色
     *
     * @param request 请求实体
     * @param userId  用户id
     * @return result实体
     */
    Result addRole(AddRoleReq request, Long userId);

    /**
     * 更新角色
     *
     * @param request 请求实体
     * @return result实体
     */
    Result updateRole(UpdateRoleReq request);

    /**
     * 根据角色查询出对应的人员信息
     *
     * @param roleName 角色名称
     * @return
     */
    Result selectUserNameByRole(final String roleName);

    /**
     * 根据角色和地市获取人员信息
     *
     * @param orgCode  地市
     * @param roleName 角色
     * @return
     */
    List<Map<String, Object>> selectPersonByCityCode(String orgCode, String roleName);
}
