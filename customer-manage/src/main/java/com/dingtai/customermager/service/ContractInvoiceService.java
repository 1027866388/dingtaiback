package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.request.AddContractInvoiceReq;
import com.dingtai.customermager.entity.request.UpdateContractInvoiceReq;
import com.dingtai.customermager.entity.response.GetContractInvoiceResp;

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

    /**
     * 删除发票
     *
     * @param id
     */
    public void deleteContractInvoice(Long id);


    /**
     * 添加合同发票
     */
    public GetContractInvoiceResp getContractInvoice(Long id);


    /**
     * 添加合同发票
     */
    public void updateContractInvoice(UpdateContractInvoiceReq updateContractInvoiceReq);
}
