package com.dingtai.customermager.entity.response;

import java.util.Date;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-23 9:31
 *  
 */
public class GetCustomerFollowResp {
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
     * 创建人
     */
    private Long creator;

    /**
     * 跟进时间
     */
    private Date createTime;


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

}
