package com.dingtai.customermager.entity.response;

import java.util.Date;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-23 10:16
 *  
 */
public class GetContractReceivablesResp {
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

}
