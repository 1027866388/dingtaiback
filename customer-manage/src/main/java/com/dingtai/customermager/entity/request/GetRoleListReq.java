package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 获取角色列表请求实体
 *
 * @author wangyanhui
 * @date 2018-03-29 16:21
 */
@ApiModel(value = "GetRoleListReq", description = "获取角色列表请求实体")
public class GetRoleListReq extends BasePageReq {
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称", name = "roleName", allowEmptyValue = true)
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
