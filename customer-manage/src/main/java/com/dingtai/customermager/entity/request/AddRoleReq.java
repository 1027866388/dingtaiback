package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 获取角色列表请求实体
 *
 * @author zoujn
 * @date 2018-04-02 13:51
 */
@ApiModel(value = "AddRoleReq", description = "新增角色请求实体")
public class AddRoleReq {
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称", name = "roleName", required = true)
    @Size(min = 2, max = 50, message = "角色名称长度在2到50之间")
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    /**
     * 角色描述
     */
    @ApiModelProperty(value = "角色描述", name = "roleDesc", allowEmptyValue = true)
    @Size(min = 2, max = 200, message = "角色描述长度在2到200之间")
    @NotBlank(message = "角色描述不能为空")
    private String roleDesc;

    /**
     * 权限Id列表
     */
    @ApiModelProperty(value = "权限Id列表", name = "permissionIds", allowEmptyValue = true)
    private List<Long> permissionIds;

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

    public List<Long> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<Long> permissionIds) {
        this.permissionIds = permissionIds;
    }
}
