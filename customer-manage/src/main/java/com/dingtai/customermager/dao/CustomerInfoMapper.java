package com.dingtai.customermager.dao;

import com.dingtai.customermager.entity.request.GetCustomerListReq;
import com.dingtai.customermager.entity.response.GetCustomerListResp;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInfoMapper {
    Page<GetCustomerListResp> listCustomer(GetCustomerListReq request);
}