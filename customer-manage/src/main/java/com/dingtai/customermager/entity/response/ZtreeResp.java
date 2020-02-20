package com.dingtai.customermager.entity.response;
import io.swagger.annotations.ApiModelProperty;

/**
 * Ztree返回实体
 *
 * @author wangyanhui
 * @date 2018-03-27 16:44
 */
public class ZtreeResp {
    /**
     * 权限id
     */
    @ApiModelProperty(value = "权限id", name = "id")
    private Long id;

    /**
     * 上级权限id
     */
    @ApiModelProperty(value = "上级权限id", name = "pId")
    private Long pId;

    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称", name = "name")
    private String name;

    /**
     * 是否展开
     */
    @ApiModelProperty(value = "是否展开", name = "open")
    private Boolean open;

    /**
     * 是否选中
     */
    @ApiModelProperty(value = "是否选中", name = "chkDisabled")
    private Boolean chkDisabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getChkDisabled() {
        return chkDisabled;
    }

    public void setChkDisabled(Boolean chkDisabled) {
        this.chkDisabled = chkDisabled;
    }
}
