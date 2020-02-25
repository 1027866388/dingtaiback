package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.dao.ContractInvoiceEntityMapper;
import com.dingtai.customermager.entity.db.ContractInvoiceEntity;
import com.dingtai.customermager.entity.request.AddContractInvoiceReq;
import com.dingtai.customermager.entity.request.UpdateContractInvoiceReq;
import com.dingtai.customermager.entity.response.GetContractInvoiceResp;
import com.dingtai.customermager.service.ContractInvoiceService;
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
public class ContractInvoiceServiceImpl implements ContractInvoiceService {

    private static Logger log = LogUtil.get();
    @Autowired
    ContractInvoiceEntityMapper contractInvoiceEntityMapper;

    @Override
    public void addContractInvoice(AddContractInvoiceReq addContractInvoiceReq) {
        ContractInvoiceEntity contractInvoiceEntity = new ContractInvoiceEntity();
        try {
            ObjectUtil.copy(addContractInvoiceReq, contractInvoiceEntity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        contractInvoiceEntity.setCreateTime(new Date());
        contractInvoiceEntity.setModifyTime(new Date());
        contractInvoiceEntity.setCreator(ShiroUtils.getUserId());
        contractInvoiceEntity.setModifier(ShiroUtils.getUserId());
        contractInvoiceEntityMapper.insertSelective(contractInvoiceEntity);

    }

    @Override
    public void deleteContractInvoice(Long id) {

        contractInvoiceEntityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public GetContractInvoiceResp getContractInvoice(Long id) {

        ContractInvoiceEntity entity = contractInvoiceEntityMapper.selectByPrimaryKey(id);
        GetContractInvoiceResp resp = new GetContractInvoiceResp();
        try {
            ObjectUtil.copy(entity, resp);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return resp;
    }

    @Override
    public void updateContractInvoice(UpdateContractInvoiceReq updateContractInvoiceReq) {
        ContractInvoiceEntity contractInvoiceEntity = new ContractInvoiceEntity();
        try {
            ObjectUtil.copy(updateContractInvoiceReq, contractInvoiceEntity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        contractInvoiceEntity.setModifyTime(new Date());
        contractInvoiceEntity.setModifier(ShiroUtils.getUserId());
        contractInvoiceEntityMapper.updateByPrimaryKeySelective(contractInvoiceEntity);
    }

}
