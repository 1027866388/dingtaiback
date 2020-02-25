package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.dao.ContractPeriodEntityMapper;
import com.dingtai.customermager.entity.db.ContractPeriodEntity;
import com.dingtai.customermager.entity.request.AddContractPeriodReq;
import com.dingtai.customermager.service.ContractPeriodService;
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
public class ContractPeriodServiceImpl implements ContractPeriodService {

    @Autowired
    ContractPeriodEntityMapper contractPeriodEntityMapper;
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
}
