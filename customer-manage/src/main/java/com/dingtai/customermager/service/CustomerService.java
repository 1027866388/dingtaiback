package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.request.GetCustomerListReq;
import com.dingtai.customermager.entity.response.GetCustomerListResp;
import com.github.pagehelper.PageInfo;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-20 15:42
 *  
 */
public interface CustomerService {
    public PageInfo<GetCustomerListResp> listCustomer(GetCustomerListReq request);
}
