package com.dingtai.customermager.entity.request;


import io.swagger.annotations.ApiModelProperty;

/**
 * 获取权限列表请求实体
 *
 * @author wangyanhui
 * @date 2018-03-27 16:35
 */
public class GetPermissionListReq extends BasePageReq {
    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称", name = "name", allowEmptyValue = true)
    private String name;

    /**
     * 类型（0目录 1菜单 2按钮）
     */
    @ApiModelProperty(value = "类型（0目录 1菜单 2按钮）", name = "type", allowEmptyValue = true)
    private byte type;

    /**
     * 上级权限id
     */
    @ApiModelProperty(value = "上级权限id", name = "parentId", allowEmptyValue = true)
    private Integer parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
