package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.dao.ProjectQuotationEntityMapper;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.db.ProjectQuotationEntity;
import com.dingtai.customermager.entity.request.AddQuotationReq;
import com.dingtai.customermager.enums.ResultCodeEnum;
import com.dingtai.customermager.exceptions.TransactionException;
import com.dingtai.customermager.service.ProjectQuotationService;
import com.dingtai.customermager.utils.LogUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 报价接口实现
 *
 * @author peng.lu
 * @date 2020/2/22
 */
@Service
public class ProjectQuotationServiceImpl implements ProjectQuotationService {

    /**
     * 日志
     */
    private static Logger log = LogUtil.get();


    /**
     * 报价单Mapper
     */
    @Autowired
    private ProjectQuotationEntityMapper projectQuotationEntityMapper;


    /**
     * 新增报价
     *
     * @param addQuotationReq 请求实体
     * @return
     */
    @Override
    public Result addQuotation(AddQuotationReq addQuotationReq) {

        Result result;

        ProjectQuotationEntity projectQuotationEntity = new ProjectQuotationEntity();
        projectQuotationEntity.setContent(addQuotationReq.getContent()); //报价内容
        projectQuotationEntity.setQuotation(addQuotationReq.getQuotation()); //报价金额
        projectQuotationEntity.setProject(addQuotationReq.getProject());  //关联项目
        projectQuotationEntity.setRemark(addQuotationReq.getRemark());  //备注

        int addProjectQuotation = projectQuotationEntityMapper.insert(projectQuotationEntity);
        if(addProjectQuotation < 0) {
            throw new TransactionException(ResultCodeEnum.APPEND_DATA_ERROR, "新增项目报价明细失败！");
        }
        result = new Result();
        return result;
    }
}
