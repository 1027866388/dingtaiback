package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.request.AddContractInvoiceReq;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-25 8:38
 *  
 */
public interface ContractInvoiceService {
    /**
     * 添加合同发票
     */
    public void addContractInvoice(AddContractInvoiceReq addContractInvoiceReq);
}
