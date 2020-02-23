package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.dao.ProjectQuotationEntityMapper;
import com.dingtai.customermager.dao.ProjectQuotationInfoMapper;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.db.ProjectQuotationEntity;
import com.dingtai.customermager.entity.request.AddQuotationReq;
import com.dingtai.customermager.entity.request.GetAllProjectQuotationListReq;
import com.dingtai.customermager.entity.request.GetProjectQuotationListReq;
import com.dingtai.customermager.entity.response.GetProjectListResp;
import com.dingtai.customermager.entity.response.GetProjectQuotationListResp;
import com.dingtai.customermager.enums.ResultCodeEnum;
import com.dingtai.customermager.exceptions.TransactionException;
import com.dingtai.customermager.service.ProjectQuotationService;
import com.dingtai.customermager.service.ProjectService;
import com.dingtai.customermager.utils.LogUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * 报价单信息Mapper
     */
    @Autowired
    private ProjectQuotationInfoMapper projectQuotationInfoMapper;


    /**
     * 项目接口
     */
    @Autowired
    private ProjectService projectService;


    /**
     * 新增报价
     *
     * @param addQuotationReq 请求实体
     * @return
     */
    @Override
    public Result addQuotation(AddQuotationReq addQuotationReq) {

        String projectName = addQuotationReq.getProjectName();
        if(projectName == null) {

            return new Result(ResultCodeEnum.REQUEST_PARAM_EMPTY, "请求参数为空!");
        }

        log.info("projectName is : " + projectName);
        Result<GetProjectListResp> projectInfo = projectService.queryProjectByName(projectName);
        if(projectInfo != null) {
            Long id = projectInfo.getData().getId();
            Result result;

            ProjectQuotationEntity projectQuotationEntity = new ProjectQuotationEntity();
            projectQuotationEntity.setContent(addQuotationReq.getContent()); //报价内容
            projectQuotationEntity.setQuotation(addQuotationReq.getQuotation()); //报价金额
            projectQuotationEntity.setProject(id);  //关联项目
            projectQuotationEntity.setRemark(addQuotationReq.getRemark());  //备注

            int addProjectQuotation = projectQuotationEntityMapper.insert(projectQuotationEntity);
            if(addProjectQuotation < 0) {
                throw new TransactionException(ResultCodeEnum.APPEND_DATA_ERROR, "新增项目报价明细失败！");
            }
            result = new Result();
            return result;
        }
        return new Result(ResultCodeEnum.APPEND_DATA_ERROR, "项目不存在!");
    }

    /**
     * 获取项目报价明细列表信息
     *
     * @param name 项目名称
     * @return 项目报价明细实体
     */
    @Override
    public List<GetProjectQuotationListResp> queryQuotationByProject(String name) {

        List<GetProjectQuotationListResp> projectQuotationInfo = projectQuotationInfoMapper.queryQuotationByProject(name);
        return projectQuotationInfo;
    }

    /**
     * 获取所有项目报价列表信息
     *
     * @param request 请求实体
     * @return 用户列表实体
     */
    @Override
    public Result<PageInfo<GetProjectQuotationListResp>> queryAllProjectQuotation(GetAllProjectQuotationListReq request) {
        Result result;
        PageHelper.startPage(request.getPageCurrent(), request.getPageSize());
        Page<GetProjectQuotationListResp> allProjectQuotations = projectQuotationInfoMapper.queryAllProjectQuotation(request);
        if (allProjectQuotations != null) {
            PageInfo<GetProjectQuotationListResp> allProjectQuotationInfo = new PageInfo(allProjectQuotations);
            result = new Result(allProjectQuotationInfo);
        } else {
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, "查询数据为空！");
        }
        return result;
    }
}
