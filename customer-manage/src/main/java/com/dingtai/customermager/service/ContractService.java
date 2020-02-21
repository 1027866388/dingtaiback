package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.request.GetContractListReq;
import com.dingtai.customermager.entity.response.GetContractListResp;
import com.github.pagehelper.PageInfo;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-21 14:36
 *  
 */
public interface ContractService {
    public PageInfo<GetContractListResp> listContract(GetContractListReq request);
}
