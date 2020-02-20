package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModelProperty;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-20 15:41
 *  
 */
public class GetCustomerReq extends BasePageReq {
    /**
     * customerName
     */
    @ApiModelProperty(value = "供应商名称", name = "customerName", allowEmptyValue = true)
    private String customerName;
}
