package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.request.GetCustomerReq;
import com.dingtai.customermager.entity.response.GetCustomerResp;
import com.github.pagehelper.PageInfo;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-20 15:42
 *  
 */
public interface CustomerService {
    public PageInfo<GetCustomerResp> listCustomer(GetCustomerReq request);
}
