package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.request.AddContractReceivablesReq;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-25 8:39
 *  
 */
public interface ContractReceivablesService {

    /**
     * 添加合同收款
     */
    public void addContractReceivables(AddContractReceivablesReq addContractReceivablesReq);
}
