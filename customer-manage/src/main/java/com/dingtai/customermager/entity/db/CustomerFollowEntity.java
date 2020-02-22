package com.dingtai.customermager.entity.db;

import java.util.Date;

public class CustomerFollowEntity {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 合同id
     */
    private Integer customerId;

    /**
     * 跟进情况
     */
    private String followCase;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态：0正常，1删除，2锁定
     */
    private Byte status;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 跟进时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long modifier;

    /**
     * 更新时间
     */
    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFollowCase() {
        return followCase;
    }

    public void setFollowCase(String followCase) {
        this.followCase = followCase;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}