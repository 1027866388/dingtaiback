package com.dingtai.customermager.entity.response;

import java.util.Date;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-23 10:15
 *  
 */
public class GetContractInvoiceResp {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 合同id
     */
    private Integer contractId;

    /**
     * 开票时间
     */
    private Date invoiceTime;

    /**
     * 开票金额
     */
    private Long invoiceMoney;

    /**
     * 发票编号
     */
    private String invoiceNo;

    /**
     * 开票人
     */
    private String invoicePerson;

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

    public Date getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(Date invoiceTime) {
        this.invoiceTime = invoiceTime;
    }

    public Long getInvoiceMoney() {
        return invoiceMoney;
    }

    public void setInvoiceMoney(Long invoiceMoney) {
        this.invoiceMoney = invoiceMoney;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoicePerson() {
        return invoicePerson;
    }

    public void setInvoicePerson(String invoicePerson) {
        this.invoicePerson = invoicePerson;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
