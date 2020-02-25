package com.dingtai.customermager.entity.response;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 获取角色列表返回实体
 *
 * @author wangyanhui
 * @date 2018-03-29 11:23
 */
public class GetRoleListResp {
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id", name = "id")
    private Long id;

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
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Date createTime;


    /**
     * 是否可以编辑
     */
    @ApiModelProperty(value = "是否可以编辑", name = "canEdit")
    private boolean canEdit;


    /**
     * 是否可删除
     */
    @ApiModelProperty(value = "是否可以删除", name = "canDelete")
    private boolean canDelete;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

}