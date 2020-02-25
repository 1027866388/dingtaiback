package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 获取角色列表请求实体
 *
 * @author wangyanhui
 * @date 2018-04-11 13:51
 */
@ApiModel(value = "UpdateRoleReq", description = "修改角色请求实体")
public class UpdateRoleReq {
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id", name = "roleId", required = true)
    @Min(0)
    @NotNull
    private Long roleId;

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
    @NotBlank(message = "角色描述称不能为空")
    private String roleDesc;

    /**
     * 权限Id列表
     */
    @ApiModelProperty(value = "权限Id列表", name = "permissionIds", allowEmptyValue = true)
    private List<Long> permissionIds;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

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
