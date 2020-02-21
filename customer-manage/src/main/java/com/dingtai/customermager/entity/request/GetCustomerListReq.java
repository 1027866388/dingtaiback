package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModelProperty;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-20 15:41
 *  
 */
public class GetCustomerListReq extends BasePageReq {
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * customerName
     */
    @ApiModelProperty(value = "供应商名称", name = "customerName", allowEmptyValue = true)
    private String customerName;
}
