package com.dingtai.customermager.entity.response;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 获取角色信息
 *
 * @author wangyanhui
 * @date 2018-04-16 15:01
 */
public class GetRoleInfoResp {
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称", name = "roleName")
    private String roleName;

    /**
     * 角色描述
     */
    @ApiModelProperty(value = "角色描述", name = "roleDesc")
    private String roleDesc;

    /**
     * 权限id列表
     */
    @ApiModelProperty(value = "权限id列表", name = "permissionIdList")
    private List<Long> permissionIdList;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Long> getPermissionIdList() {
        return permissionIdList;
    }

    public void setPermissionIdList(List<Long> permissionIdList) {
        this.permissionIdList = permissionIdList;
    }
}