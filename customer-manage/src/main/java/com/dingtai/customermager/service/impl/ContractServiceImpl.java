package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.dao.*;
import com.dingtai.customermager.entity.db.ContractEntity;
import com.dingtai.customermager.entity.request.AddContractReq;
import com.dingtai.customermager.entity.request.GetContractListReq;
import com.dingtai.customermager.entity.request.UpdateContractReq;
import com.dingtai.customermager.entity.response.GetContractInvoiceResp;
import com.dingtai.customermager.entity.response.GetContractPeriodResp;
import com.dingtai.customermager.entity.response.GetContractReceivablesResp;
import com.dingtai.customermager.entity.response.GetContractResp;
import com.dingtai.customermager.service.ContractService;
import com.dingtai.customermager.utils.LogUtil;
import com.dingtai.customermager.utils.ObjectUtil;
import com.dingtai.customermager.utils.ShiroUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
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

    private static Logger log = LogUtil.get();

    @Override
    public PageInfo<GetContractResp> listContract(GetContractListReq request) {
        PageHelper.startPage(request.getPageCurrent(), request.getPageSize());
        Page<GetContractResp> listContract = contractInfoMapper.listContract(request);
        PageInfo<GetContractResp> listContractPageInfo = new PageInfo(listContract);
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
        ContractEntity contractEntity = new ContractEntity();
        try {
            ObjectUtil.copy(addContractReq, contractEntity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        contractEntity.setCreateTime(new Date());
        contractEntity.setModifyTime(new Date());
        contractEntity.setCreator(ShiroUtils.getUserId());
        contractEntity.setModifier(ShiroUtils.getUserId());
        contractEntityMapper.insertSelective(contractEntity);
    }

    @Override
    public void updateContract(UpdateContractReq updateContractReq) {
        ContractEntity contractEntity = new ContractEntity();
        try {
            ObjectUtil.copy(updateContractReq, contractEntity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        contractEntity.setModifyTime(new Date());
        contractEntity.setModifier(ShiroUtils.getUserId());
        contractEntityMapper.updateByPrimaryKeySelective(contractEntity);
    }

    @Override
    public GetContractResp getContract(long id) {
        ContractEntity contractEntity = contractEntityMapper.selectByPrimaryKey(id);
        GetContractResp resp = new GetContractResp();
        try {
            ObjectUtil.copy(contractEntity, resp);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return resp;
    }

}
