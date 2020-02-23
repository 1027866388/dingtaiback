package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.AddQuotationReq;
import com.dingtai.customermager.entity.response.GetProjectQuotationListResp;

import java.util.List;

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


    /**
     * 获取项目报价明细列表信息
     *
     * @param name 项目名称
     * @return 项目报价明细实体
     */
    List<GetProjectQuotationListResp> queryQuotationByProject(String name);
}
