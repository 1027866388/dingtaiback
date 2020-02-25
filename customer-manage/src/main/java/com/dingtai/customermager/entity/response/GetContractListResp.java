package com.dingtai.customermager.entity.response;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-21 14:47
 *  
 */
public class GetContractListResp {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "id", name = "id")
    private Long id;

    /**
     * 合同编号
     */
    @ApiModelProperty(value = "合同编号", name = "contractNo")
    private String contractNo;

    /**
     * 合同名称
     */
    @ApiModelProperty(value = "合同名称", name = "contractName")
    private String contractName;

    /**
     * 签订时间
     */
    @ApiModelProperty(value = "签订时间", name = "signTime")
    private Date signTime;

    /**
     * 合同金额
     */
    @ApiModelProperty(value = "签订金额", name = "contractMoney")
    private BigDecimal contractMoney;

    /**
     * 客户id
     */
    @ApiModelProperty(value = "客户id", name = "customerId")
    private Long customerId;

    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称", name = "customerName")
    private String customerName;

    /**
     * 状态：0 未完成，1完成，2删除
     */
    @ApiModelProperty(value = "合同状态：0 未完成，1已完成", name = "customerName")
    private Byte status;

    public BigDecimal getFinishMoney() {
        return finishMoney;
    }

    public void setFinishMoney(BigDecimal finishMoney) {
        this.finishMoney = finishMoney;
    }

    /**
     * 已完成金额
     */
    @ApiModelProperty(value = "已完成金额", name = "finishMoney")
    private BigDecimal finishMoney;

    public BigDecimal getUnFinishMoney() {
        return unFinishMoney;
    }

    public void setUnFinishMoney(BigDecimal unFinishMoney) {
        this.unFinishMoney = unFinishMoney;
    }

    /**
     * 未完成金额
     */
    @ApiModelProperty(value = "未完成金额", name = "unFinishMoney")
    private BigDecimal unFinishMoney;

    public BigDecimal getReceiveMoney() {
        return receiveMoney;
    }

    public void setReceiveMoney(BigDecimal receiveMoney) {
        this.receiveMoney = receiveMoney;
    }

    /**
     * 已收款金额
     */
    @ApiModelProperty(value = "已收款金额", name = "receiveMoney")
    private BigDecimal receiveMoney;

    public BigDecimal getUnReceiveMoney() {
        return unReceiveMoney;
    }

    public void setUnReceiveMoney(BigDecimal unReceiveMoney) {
        this.unReceiveMoney = unReceiveMoney;
    }

    /**
     * 未收款金额
     */
    @ApiModelProperty(value = "未收款金额", name = "unReceiveMoney")
    private BigDecimal unReceiveMoney;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public BigDecimal getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(BigDecimal contractMoney) {
        this.contractMoney = contractMoney;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


}
