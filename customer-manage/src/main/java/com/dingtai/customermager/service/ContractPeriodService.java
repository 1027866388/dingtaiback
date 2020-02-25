package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.request.AddContractPeriodReq;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-25 8:38
 *  
 */
public interface ContractPeriodService {
    /**
     * 添加合同期间
     */
    public void addContractPeriod(AddContractPeriodReq addContractPeriodReq);
}
