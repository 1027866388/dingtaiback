package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.request.AddContractPeriodReq;
import com.dingtai.customermager.entity.request.UpdateContractPeriodReq;
import com.dingtai.customermager.entity.response.GetContractPeriodResp;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-25 8:38
 *  
 */
public interface ContractPeriodService {
    /**
     * 添加合同期间
     */
    public void addContractPeriod(AddContractPeriodReq addContractPeriodReq);

    /**
     * 删除期间
     *
     * @param id
     */
    public void deleteContractPeriod(Long id);

    /**
     * 获取合同期间
     */
    public GetContractPeriodResp getContractPeriod(Long id);


    /**
     * 更新合同期间
     */
    public void updateContractPeriod(UpdateContractPeriodReq updateContractPeriodReq);
}
