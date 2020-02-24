package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-24 15:01
 *  
 */
public class AddContractReceivablesReq {

    /**
     * 合同id
     */
    @ApiModelProperty(value = "合同id", name = "contractId", allowEmptyValue = false)
    @NotNull(message = "合同id不能为空")
    private Integer contractId;

    /**
     * 收款时间
     */
    @ApiModelProperty(value = "收款时间", name = "receiveTime", allowEmptyValue = false)
    @NotNull(message = "收款时间不能为空")
    private Date receiveTime;

    /**
     * 收款金额
     */
    @ApiModelProperty(value = "收款金额", name = "receiveMoney", allowEmptyValue = false)
    @NotNull(message = "收款金额不能为空")
    private BigDecimal receiveMoney;

    /**
     * 收款方式
     */
    @ApiModelProperty(value = "收款方式", name = "receiveMethod", allowEmptyValue = false)
    @Size(min = 2, max = 200, message = "收款方式长度在2-200之间")
    @NotBlank(message = "收款方式不能为空")
    private String receiveMethod;

    /**
     * 收款人
     */
    @ApiModelProperty(value = "收款人", name = "receivePerson", allowEmptyValue = false)
    @Size(min = 2, max = 200, message = "收款人长度在2-200之间")
    @NotBlank(message = "收款人不能为空")
    private String receivePerson;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", name = "contractName", allowEmptyValue = false)
    private String remark;


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

    public BigDecimal getReceiveMoney() {
        return receiveMoney;
    }

    public void setReceiveMoney(BigDecimal receiveMoney) {
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
