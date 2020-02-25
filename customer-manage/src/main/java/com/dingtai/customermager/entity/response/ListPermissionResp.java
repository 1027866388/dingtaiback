package com.dingtai.customermager.entity.response;
import io.swagger.annotations.ApiModelProperty;

/**
 * 获取权限列表返回实体
 *
 * @author wangyanhui
 * @date 2018-03-27 16:44
 */
public class ListPermissionResp {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "权限id", name = "id")
    private Long id;

    /**
     * 上级权限id
     */
    @ApiModelProperty(value = "上级权限id", name = "parentId")
    private Long parentId;

    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称", name = "name")
    private String name;

    /**
     * 权限标识（多个用逗号分隔）
     */
    @ApiModelProperty(value = "权限标识", name = "perms")
    private String perms;

    /**
     * 类型（0目录 1菜单 2按钮）
     */
    @ApiModelProperty(value = "类型", name = "type")
    private Byte type;

    /**
     * 图表对应的图片名称
     */
    @ApiModelProperty(value = "图表对应的图片名称", name = "picName")
    private String picName;

    /**
     * 上级权限名称
     */
    @ApiModelProperty(value = "上级权限名称", name = "parentName")
    private String parentName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }


    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }
}
