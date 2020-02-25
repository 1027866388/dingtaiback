package com.dingtai.customermager.entity.response;

import java.util.Date;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-23 10:16
 *  
 */
public class GetContractPeriodResp {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 合同id
     */
    private Integer contractId;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 期间金额
     */
    private Long periodMoney;

    /**
     * 期间名称
     */
    private String periodName;

    /**
     * 期间内容
     */
    private String periodContent;

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

    public Long getPeriodMoney() {
        return periodMoney;
    }

    public void setPeriodMoney(Long periodMoney) {
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
