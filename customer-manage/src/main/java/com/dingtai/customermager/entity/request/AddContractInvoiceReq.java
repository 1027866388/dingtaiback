package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModelProperty;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-24 15:00
 *  
 */
public class AddContractInvoiceReq {

    /**
     * 合同id
     */
    @ApiModelProperty(value = "合同id", name = "contractId", allowEmptyValue = false)
    @NotNull(message = "合同id不能为空")
    @Min(0)
    private Long contractId;

    /**
     * 开票时间
     */
    @ApiModelProperty(value = "开票时间", name = "invoiceTime", allowEmptyValue = false)
    @NotNull(message = "开票时间不能为空")
    private Date invoiceTime;

    /**
     * 开票金额
     */
    @ApiModelProperty(value = "发票金额", name = "invoiceMoney", allowEmptyValue = false)
    @NotNull(message = "发票金额不能为空")
    private BigDecimal invoiceMoney;

    /**
     * 发票编号
     */
    @ApiModelProperty(value = "发票编号", name = "invoiceNo", allowEmptyValue = false)
    @NotBlank(message = "发票编号不能为空")
    private String invoiceNo;

    /**
     * 开票人
     */
    @ApiModelProperty(value = "开票人", name = "invoicePerson", allowEmptyValue = false)
    @NotNull(message = "开票人不能为空")
    private String invoicePerson;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", name = "remark", allowEmptyValue = true)
    private String remark;


    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Date getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(Date invoiceTime) {
        this.invoiceTime = invoiceTime;
    }

    public BigDecimal getInvoiceMoney() {
        return invoiceMoney;
    }

    public void setInvoiceMoney(BigDecimal invoiceMoney) {
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
