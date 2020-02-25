package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.dao.ContractInvoiceEntityMapper;
import com.dingtai.customermager.entity.db.ContractInvoiceEntity;
import com.dingtai.customermager.entity.request.AddContractInvoiceReq;
import com.dingtai.customermager.service.ContractInvoiceService;
import com.dingtai.customermager.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-25 8:57
 *  
 */
@Service
public class ContractInvoiceServiceImpl implements ContractInvoiceService {

    @Autowired
    ContractInvoiceEntityMapper contractInvoiceEntityMapper;
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
}
