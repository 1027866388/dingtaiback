package com.dingtai.customermager.entity.response;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 获取权限树返回实体
 *
 * @author wangyanhui
 * @date 2018-04-13 16:09
 */
public class GetPermissionTreeResp {
    /**
     * 权限id
     */
    @ApiModelProperty(value = "权限id", name = "permissionId")
    private Long permissionId;

    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称", name = "name")
    private String name;

    /**
     * 类型（0目录 1菜单 2按钮）
     */
    @ApiModelProperty(value = "类型（0目录 1菜单 2按钮）", name = "type")
    private byte type;


    /**
     * 权限图标
     */
    @ApiModelProperty(value = "权限图标", name = "picName")
    private String picName;

    /**
     * 权限子集合
     */
    @ApiModelProperty(value = "权限子集合", name = "children")
    private List<GetPermissionTreeResp> children;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GetPermissionTreeResp> getChildren() {
        return children;
    }

    public void setChildren(List<GetPermissionTreeResp> children) {
        this.children = children;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }
}
