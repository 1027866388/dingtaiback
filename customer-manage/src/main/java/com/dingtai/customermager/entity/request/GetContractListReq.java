package com.dingtai.customermager.entity.request;

import com.fasterxml.jackson.databind.ser.Serializers;
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
}
