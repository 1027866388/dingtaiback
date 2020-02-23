package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.GetCustomerListReq;
import com.dingtai.customermager.entity.response.GetCustomerFollowResp;
import com.dingtai.customermager.entity.response.GetCustomerListResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-20 15:42
 *  
 */
public interface CustomerService {
    public PageInfo<GetCustomerListResp> listCustomer(GetCustomerListReq request);
    public List<GetCustomerFollowResp> getCustomerFollow(long customerId);
}
