package com.dingtai.customermager.dao;

import com.dingtai.customermager.entity.request.GetCustomerListReq;
import com.dingtai.customermager.entity.response.GetCustomerFollowResp;
import com.dingtai.customermager.entity.response.GetCustomerListResp;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerInfoMapper {
    Page<GetCustomerListResp> listCustomer(GetCustomerListReq request);
    List<GetCustomerFollowResp> getCustomerFollow(@Param("customerId") long customerId );
}