package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.dao.*;
import com.dingtai.customermager.entity.db.ContractEntity;
import com.dingtai.customermager.entity.db.ContractInvoiceEntity;
import com.dingtai.customermager.entity.db.ContractPeriodEntity;
import com.dingtai.customermager.entity.db.ContractReceivablesEntity;
import com.dingtai.customermager.entity.request.*;
import com.dingtai.customermager.entity.response.*;
import com.dingtai.customermager.service.ContractService;
import com.dingtai.customermager.utils.ShiroUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    private ContractEntityMapper contractEntityMapper;

    @Autowired
    private ContractInvoiceEntityMapper contractInvoiceEntityMapper;

    @Autowired
    private ContractPeriodEntityMapper contractPeriodEntityMapper;

    @Autowired
    private ContractReceivablesEntityMapper contractReceivablesEntityMapper;

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

    @Override
    public void deleteContract(Long contractId) {
        contractEntityMapper.deleteByPrimaryKey(contractId);
        contractInfoMapper.deleteInvoiceByContractId(contractId);
        contractInfoMapper.deletePeriodByContractId(contractId);
        contractInfoMapper.deleteReceivablesByContractId(contractId);
    }

    @Override
    public void addContract(AddContractReq addContractReq) {
        ContractEntity contractEntity=new ContractEntity();
        contractEntity.setContractMoney(addContractReq.getContractMoney());
        contractEntity.setContractName(addContractReq.getContractName());
        contractEntity.setContractNo(addContractReq.getContractNo());
        contractEntity.setCustomerId(addContractReq.getCustomerId());
        contractEntity.setContractName(addContractReq.getContractName());
        contractEntity.setSignTime(addContractReq.getSignTime());
        contractEntity.setCreateTime(new Date());
        contractEntity.setModifyTime(new Date());
        contractEntity.setCreator(ShiroUtils.getUserId());
        contractEntity.setModifier(ShiroUtils.getUserId());
        contractEntityMapper.insertSelective(contractEntity);
    }

}
