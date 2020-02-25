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
    /**
     * 客户列表
     * @param request
     * @return
     */
    Page<GetCustomerListResp> listCustomer(GetCustomerListReq request);

    /**
     * 获取客户跟进记录
     * @param customerId
     * @return
     */
    List<GetCustomerFollowResp> getCustomerFollow(@Param("customerId") long customerId );

    /**
     * 删除客户跟进记录
     * @param customerId
     * @return
     */
    Long deleteFollowByCustomerId(@Param("customerId") long customerId );
}