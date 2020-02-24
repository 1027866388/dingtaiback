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

    @Override
    public void addContractInvoice(AddContractInvoiceReq addContractInvoiceReq) {
        ContractInvoiceEntity contractInvoiceEntity=new ContractInvoiceEntity();
        contractInvoiceEntity.setContractId(addContractInvoiceReq.getContractId());
        contractInvoiceEntity.setInvoiceMoney(addContractInvoiceReq.getInvoiceMoney());
        contractInvoiceEntity.setInvoiceNo(addContractInvoiceReq.getInvoiceNo());
        contractInvoiceEntity.setInvoicePerson(addContractInvoiceReq.getInvoicePerson());
        contractInvoiceEntity.setInvoiceTime(addContractInvoiceReq.getInvoiceTime());
        contractInvoiceEntity.setRemark(addContractInvoiceReq.getRemark());
        contractInvoiceEntity.setCreateTime(new Date());
        contractInvoiceEntity.setModifyTime(new Date());
        contractInvoiceEntity.setCreator(ShiroUtils.getUserId());
        contractInvoiceEntity.setModifier(ShiroUtils.getUserId());
        contractInvoiceEntityMapper.insertSelective(contractInvoiceEntity);

    }

    @Override
    public void addContractPeriod(AddContractPeriodReq addContractPeriodReq) {
        ContractPeriodEntity contractPeriodEntity=new ContractPeriodEntity();
        contractPeriodEntity.setContractId(addContractPeriodReq.getContractId());
        contractPeriodEntity.setPeriodContent(addContractPeriodReq.getPeriodContent());
        contractPeriodEntity.setPeriodMoney(addContractPeriodReq.getPeriodMoney());
        contractPeriodEntity.setPeriodName(addContractPeriodReq.getPeriodName());
        contractPeriodEntity.setCreateTime(new Date());
        contractPeriodEntity.setModifyTime(new Date());
        contractPeriodEntity.setCreator(ShiroUtils.getUserId());
        contractPeriodEntity.setModifier(ShiroUtils.getUserId());
        contractPeriodEntityMapper.insertSelective(contractPeriodEntity);
    }

    @Override
    public void addContractReceivables(AddContractReceivablesReq addContractReceivablesReq) {
        ContractReceivablesEntity contractReceivablesEntity=new ContractReceivablesEntity();
        contractReceivablesEntity.setContractId(contractReceivablesEntity.getContractId());
        contractReceivablesEntity.setReceiveMethod(contractReceivablesEntity.getReceiveMethod());
        contractReceivablesEntity.setReceivePerson(contractReceivablesEntity.getReceivePerson());
        contractReceivablesEntity.setReceiveTime(contractReceivablesEntity.getReceiveTime());
        contractReceivablesEntity.setReceiveMoney(contractReceivablesEntity.getReceiveMoney());
        contractReceivablesEntity.setRemark(contractReceivablesEntity.getRemark());
        contractReceivablesEntity.setCreateTime(new Date());
        contractReceivablesEntity.setModifyTime(new Date());
        contractReceivablesEntity.setCreator(ShiroUtils.getUserId());
        contractReceivablesEntity.setModifier(ShiroUtils.getUserId());
    }
}
