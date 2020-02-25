package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.dao.ContractReceivablesEntityMapper;
import com.dingtai.customermager.entity.db.ContractReceivablesEntity;
import com.dingtai.customermager.entity.request.AddContractReceivablesReq;
import com.dingtai.customermager.entity.request.UpdateContractReceivablesReq;
import com.dingtai.customermager.entity.response.GetContractReceivablesResp;
import com.dingtai.customermager.service.ContractReceivablesService;
import com.dingtai.customermager.utils.LogUtil;
import com.dingtai.customermager.utils.ObjectUtil;
import com.dingtai.customermager.utils.ShiroUtils;
import org.slf4j.Logger;
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

    private static Logger log = LogUtil.get();
    @Autowired
    ContractReceivablesEntityMapper ContractReceivablesEntityMapper;

    @Override
    public void addContractReceivables(AddContractReceivablesReq addContractReceivablesReq) {
        ContractReceivablesEntity contractReceivablesEntity = new ContractReceivablesEntity();
        try {
            ObjectUtil.copy(addContractReceivablesReq, contractReceivablesEntity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        contractReceivablesEntity.setCreateTime(new Date());
        contractReceivablesEntity.setModifyTime(new Date());
        contractReceivablesEntity.setCreator(ShiroUtils.getUserId());
        contractReceivablesEntity.setModifier(ShiroUtils.getUserId());
        ContractReceivablesEntityMapper.insertSelective(contractReceivablesEntity);

    }

    @Override
    public void deleteContractReceivables(Long id) {

        ContractReceivablesEntityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public GetContractReceivablesResp getContractReceivables(Long id) {

        ContractReceivablesEntity entity = ContractReceivablesEntityMapper.selectByPrimaryKey(id);
        GetContractReceivablesResp resp = new GetContractReceivablesResp();
        try {
            ObjectUtil.copy(entity, resp);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return resp;
    }

    @Override
    public void updateContractReceivables(UpdateContractReceivablesReq updateContractReceivablesReq) {
        ContractReceivablesEntity ContractReceivablesEntity = new ContractReceivablesEntity();
        try {
            ObjectUtil.copy(updateContractReceivablesReq, ContractReceivablesEntity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        ContractReceivablesEntity.setModifyTime(new Date());
        ContractReceivablesEntity.setModifier(ShiroUtils.getUserId());
        ContractReceivablesEntityMapper.updateByPrimaryKeySelective(ContractReceivablesEntity);
    }
}
