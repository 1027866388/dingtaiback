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
    /**
     * 客户列表
     * @param request
     * @return
     */
    public PageInfo<GetCustomerListResp> listCustomer(GetCustomerListReq request);

    /**
     * 客户跟进记录
     * @param customerId
     * @return
     */
    public List<GetCustomerFollowResp> getCustomerFollow(long customerId);

    /**
     * 删除客户
     * @param customerId
     */
    public void deleteCustomer(long customerId);
}
