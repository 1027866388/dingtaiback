package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.dao.CustomerInfoMapper;
import com.dingtai.customermager.entity.request.GetCustomerReq;
import com.dingtai.customermager.entity.response.GetCustomerResp;
import com.dingtai.customermager.entity.response.GetUserListResp;
import com.dingtai.customermager.service.CustomerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-20 16:13
 *  
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Override
    public PageInfo<GetCustomerResp> listCustomer(GetCustomerReq request) {
        PageHelper.startPage(request.getPageCurrent(), request.getPageSize());
        Page<GetCustomerResp> listCustomer = customerInfoMapper.listCustomer(request);
        PageInfo<GetCustomerResp> listCustomerPageInfo = new PageInfo(listCustomer);
        return listCustomerPageInfo;
    }
}
