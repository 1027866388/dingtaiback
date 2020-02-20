package com.dingtai.customermager.dao;

import com.dingtai.customermager.entity.db.CustomerEntity;
import com.dingtai.customermager.entity.request.GetCustomerReq;
import com.dingtai.customermager.entity.request.GetUserListReq;
import com.dingtai.customermager.entity.response.GetCustomerResp;
import com.dingtai.customermager.entity.response.GetUserListResp;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInfoMapper {
    Page<GetCustomerResp> listCustomer(GetCustomerReq request);
}