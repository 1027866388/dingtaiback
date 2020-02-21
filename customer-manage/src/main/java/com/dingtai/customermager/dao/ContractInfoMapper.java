package com.dingtai.customermager.dao;

import com.dingtai.customermager.entity.db.ContractEntity;
import com.dingtai.customermager.entity.request.GetContractListReq;
import com.dingtai.customermager.entity.request.GetCustomerListReq;
import com.dingtai.customermager.entity.response.GetContractListResp;
import com.dingtai.customermager.entity.response.GetCustomerListResp;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractInfoMapper {
    Page<GetContractListResp> listContract(GetContractListReq request);
}