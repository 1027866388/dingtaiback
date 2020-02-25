package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModelProperty;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-21 14:46
 *  
 */
public class GetContractListReq extends BasePageReq {


    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    /**
     * customerName
     */
    @ApiModelProperty(value = "合同编号", name = "contractNo", allowEmptyValue = true)
    private String contractNo;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ApiModelProperty(value = "状态 0未完成 1已完成", name = "status", allowEmptyValue = true)
    private Integer status;
}
