package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.request.AddContractReceivablesReq;
import com.dingtai.customermager.entity.request.UpdateContractReceivablesReq;
import com.dingtai.customermager.entity.response.GetContractReceivablesResp;

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

    /**
     * 删除合同收款
     *
     * @param id
     */
    public void deleteContractReceivables(Long id);

    /**
     * 获取合同收款
     */
    public GetContractReceivablesResp getContractReceivables(Long id);


    /**
     * 更新合同期收款
     */
    public void updateContractReceivables(UpdateContractReceivablesReq updateContractReceivablesReq);
}
