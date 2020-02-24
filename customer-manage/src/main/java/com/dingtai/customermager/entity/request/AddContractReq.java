package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModelProperty;

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
 *  @date 2020-02-24 14:59
 *  
 */
public class AddContractReq {


    /**
     * 合同编号
     */
    @ApiModelProperty(value = "合同编号", name = "contractNo", allowEmptyValue = false)
    @Size(min = 2, max = 100, message = "合同编号长度在2-100之间")
    @NotBlank(message = "合同编号不能为空")
    private String contractNo;

    /**
     * 合同名称
     */
    @ApiModelProperty(value = "合同名称", name = "contractName", allowEmptyValue = false)
    @Size(min = 2, max = 200, message = "合同名称长度在2-200之间")
    @NotBlank(message = "合同名称不能为空")
    private String contractName;

    /**
     * 签订时间
     */
    @ApiModelProperty(value = "签订时间", name = "signTime", allowEmptyValue = false)
    @NotNull(message = "签订时间不能为空")
    private Date signTime;

    /**
     * 合同金额
     */
    @ApiModelProperty(value = "合同金额", name = "contractMoney", allowEmptyValue = false)
    @Min(0)
    @NotNull(message = "合同金额不能为空")
    private BigDecimal contractMoney;

    /**
     * 客户id
     */
    @ApiModelProperty(value = "客户id", name = "customerId", allowEmptyValue = false)
    @Min(0)
    @NotNull(message = "客户id不能为空")
    private Long customerId;

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

}
