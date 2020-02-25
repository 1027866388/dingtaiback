package com.dingtai.customermager.dao;

import com.dingtai.customermager.entity.request.GetAllProjectQuotationListReq;
import com.dingtai.customermager.entity.response.GetProjectQuotationListResp;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目报价信息Mapper
 *
 * @author peng.lu
 * @date 2020/2/22
 */

@Repository
public interface ProjectQuotationInfoMapper {

    /**
     * 获取项目报价明细列表
     *
     * @param name 项目名称
     * @return 分页项目报价列表
     */
    List<GetProjectQuotationListResp> queryQuotationByProject(String name);

    /**
     * 获取所有项目报价信息列表
     *
     * @param request 请求实体
     * @return 分页用户列表
     */
    Page<GetProjectQuotationListResp> queryAllProjectQuotation(GetAllProjectQuotationListReq request);
}
