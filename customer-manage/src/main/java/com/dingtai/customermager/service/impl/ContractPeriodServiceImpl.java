package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.dao.ContractPeriodEntityMapper;
import com.dingtai.customermager.entity.db.ContractPeriodEntity;
import com.dingtai.customermager.entity.request.AddContractPeriodReq;
import com.dingtai.customermager.entity.request.UpdateContractPeriodReq;
import com.dingtai.customermager.entity.response.GetContractPeriodResp;
import com.dingtai.customermager.service.ContractPeriodService;
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
public class ContractPeriodServiceImpl implements ContractPeriodService {

    private static Logger log = LogUtil.get();
    @Autowired
    ContractPeriodEntityMapper contractPeriodEntityMapper;

    @Override
    public void addContractPeriod(AddContractPeriodReq addContractPeriodReq) {
        ContractPeriodEntity contractPeriodEntity = new ContractPeriodEntity();
        try {
            ObjectUtil.copy(addContractPeriodReq, contractPeriodEntity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        contractPeriodEntity.setCreateTime(new Date());
        contractPeriodEntity.setModifyTime(new Date());
        contractPeriodEntity.setCreator(ShiroUtils.getUserId());
        contractPeriodEntity.setModifier(ShiroUtils.getUserId());
        contractPeriodEntityMapper.insertSelective(contractPeriodEntity);

    }

    @Override
    public void deleteContractPeriod(Long id) {

        contractPeriodEntityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public GetContractPeriodResp getContractPeriod(Long id) {

        ContractPeriodEntity entity = contractPeriodEntityMapper.selectByPrimaryKey(id);
        GetContractPeriodResp resp = new GetContractPeriodResp();
        try {
            ObjectUtil.copy(entity, resp);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return resp;
    }

    @Override
    public void updateContractPeriod(UpdateContractPeriodReq updateContractPeriodReq) {
        ContractPeriodEntity contractPeriodEntity = new ContractPeriodEntity();
        try {
            ObjectUtil.copy(updateContractPeriodReq, contractPeriodEntity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        contractPeriodEntity.setModifyTime(new Date());
        contractPeriodEntity.setModifier(ShiroUtils.getUserId());
        contractPeriodEntityMapper.updateByPrimaryKeySelective(contractPeriodEntity);
    }

}
