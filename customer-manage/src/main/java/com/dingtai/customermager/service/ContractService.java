package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.request.AddContractReq;
import com.dingtai.customermager.entity.request.GetContractListReq;
import com.dingtai.customermager.entity.request.UpdateContractReq;
import com.dingtai.customermager.entity.response.GetContractInvoiceResp;
import com.dingtai.customermager.entity.response.GetContractPeriodResp;
import com.dingtai.customermager.entity.response.GetContractReceivablesResp;
import com.dingtai.customermager.entity.response.GetContractResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-21 14:36
 *  
 */
public interface ContractService {
    /**
     * 合同分页接口
     *
     * @param request
     * @return
     */
    public PageInfo<GetContractResp> listContract(GetContractListReq request);

    /**
     * 获取合同发票信息
     *
     * @param contractId
     * @return
     */
    public List<GetContractInvoiceResp> getContractInvoice(long contractId);

    /**
     * 获取合同期间信息
     *
     * @param contractId
     * @return
     */
    public List<GetContractPeriodResp> getContractPeriod(long contractId);

    /**
     * 获取合同收款信息
     *
     * @param contractId
     * @return
     */
    public List<GetContractReceivablesResp> getContractReceivables(long contractId);

    /**
     * 删除合同
     */
    public void deleteContract(Long contractId);

    /**
     * 添加合同
     */
    public void addContract(AddContractReq addContractReq);


    /**
     * 更新合同基本信息
     *
     * @param updateContractReq
     */
    public void updateContract(UpdateContractReq updateContractReq);

    /**
     * 得到合同基本信息
     *
     * @param id
     * @return
     */
    public GetContractResp getContract(long id);


}
