package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.AddQuotationReq;

/**
 * 报价接口
 *
 * @author peng.lu
 * @date 2020/2/22
 */
public interface ProjectQuotationService {

    /**
     * 新增报价
     *
     * @param req 请求实体
     * @return Result实体
     */
    public Result addQuotation(AddQuotationReq req);
}
