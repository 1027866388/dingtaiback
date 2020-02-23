package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.dao.ContractInfoMapper;
import com.dingtai.customermager.dao.CustomerInfoMapper;
import com.dingtai.customermager.entity.request.GetContractListReq;
import com.dingtai.customermager.entity.request.GetCustomerListReq;
import com.dingtai.customermager.entity.response.*;
import com.dingtai.customermager.service.ContractService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-21 14:44
 *  
 */
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractInfoMapper contractInfoMapper;
    @Override
    public PageInfo<GetContractListResp> listContract(GetContractListReq request) {
        PageHelper.startPage(request.getPageCurrent(), request.getPageSize());
        Page<GetContractListResp> listContract = contractInfoMapper.listContract(request);
        PageInfo<GetContractListResp> listContractPageInfo = new PageInfo(listContract);
        return listContractPageInfo;
    }

    @Override
    public List<GetContractInvoiceResp> getContractInvoice(long contractId) {
        return contractInfoMapper.getContractInvoice(contractId);
    }

    @Override
    public List<GetContractPeriodResp> getContractPeriod(long contractId) {
        return contractInfoMapper.getContractPeriod(contractId);
    }

    @Override
    public List<GetContractReceivablesResp> getContractReceivables(long contractId) {
        return contractInfoMapper.getContractReceivables(contractId);
    }
}
