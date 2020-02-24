package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModelProperty;

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
public class AddContractPeriodReq {

    /**
     * 合同id
     */
    @ApiModelProperty(value = "合同id", name = "contractId", allowEmptyValue = false)
    @NotNull(message = "开票时间不能为空")
    private Integer contractId;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间", name = "startTime", allowEmptyValue = false)
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间", name = "endTime", allowEmptyValue = false)
    private Date endTime;

    /**
     * 期间金额
     */
    @ApiModelProperty(value = "期间金额", name = "periodMoney", allowEmptyValue = false)
    private BigDecimal periodMoney;

    /**
     * 期间名称
     */
    @ApiModelProperty(value = "期间名称", name = "periodName", allowEmptyValue = false)
    @Size(min = 2, max = 200, message = "期间名称长度在2-200之间")
    @NotBlank(message = "期间名称不能为空")
    private String periodName;

    /**
     * 期间内容
     */
    @ApiModelProperty(value = "期间内容", name = "periodMoney", allowEmptyValue = false)
    @Size(min = 2, max = 200, message = "期间内容长度在2-200之间")
    @NotBlank(message = "期间内容不能为空")
    private String periodContent;


    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getPeriodMoney() {
        return periodMoney;
    }

    public void setPeriodMoney(BigDecimal periodMoney) {
        this.periodMoney = periodMoney;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public String getPeriodContent() {
        return periodContent;
    }

    public void setPeriodContent(String periodContent) {
        this.periodContent = periodContent;
    }
}
