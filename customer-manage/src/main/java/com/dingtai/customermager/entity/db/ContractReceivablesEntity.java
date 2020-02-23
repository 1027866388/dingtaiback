package com.dingtai.customermager.entity.db;

import java.util.Date;

public class ContractReceivablesEntity {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 合同id
     */
    private Integer contractId;

    /**
     * 收款时间
     */
    private Date receiveTime;

    /**
     * 收款金额
     */
    private Long receiveMoney;

    /**
     * 收款方式
     */
    private String receiveMethod;

    /**
     * 收款人
     */
    private String receivePerson;

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
     * 创建时间
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

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Long getReceiveMoney() {
        return receiveMoney;
    }

    public void setReceiveMoney(Long receiveMoney) {
        this.receiveMoney = receiveMoney;
    }

    public String getReceiveMethod() {
        return receiveMethod;
    }

    public void setReceiveMethod(String receiveMethod) {
        this.receiveMethod = receiveMethod;
    }

    public String getReceivePerson() {
        return receivePerson;
    }

    public void setReceivePerson(String receivePerson) {
        this.receivePerson = receivePerson;
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