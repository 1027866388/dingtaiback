package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 更新权限请求实体
 *
 * @author wangyanhui
 * @date 2018-04-15 21:17
 */
@ApiModel(value = "UpdatePermissionReq", description = "更新权限请求实体")
public class UpdatePermissionReq {
    /**
     * 权限id
     */
    @ApiModelProperty(value = "权限id", name = "permissionId", required = true)
    private Long permissionId;
    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称", name = "name", required = true)
    private String name;

    /**
     * 上级权限id
     */
    @ApiModelProperty(value = "上级权限id", name = "parentId", required = true)
    private Long parentId;

    /**
     * 权限标识（多个用逗号分隔）
     */
    @ApiModelProperty(value = "权限标识（多个用逗号分隔）", name = "perms", allowEmptyValue = true)
    private String perms;

    /**
     * 类型（0目录 1菜单 2按钮）
     */
    @ApiModelProperty(value = "类型（0目录 1菜单 2按钮）", name = "type", required = true)
    private Byte type;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序", name = "orderNum", allowEmptyValue = true)
    private Integer orderNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
