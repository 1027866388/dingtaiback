package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.dao.ContractReceivablesEntityMapper;
import com.dingtai.customermager.entity.db.ContractReceivablesEntity;
import com.dingtai.customermager.entity.request.AddContractReceivablesReq;
import com.dingtai.customermager.service.ContractReceivablesService;
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
public class ContractReceivablesServiceImpl implements ContractReceivablesService {

    @Autowired
    ContractReceivablesEntityMapper contractReceivablesEntityMapper;
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
        contractReceivablesEntityMapper.insertSelective(contractReceivablesEntity);
    }
}
