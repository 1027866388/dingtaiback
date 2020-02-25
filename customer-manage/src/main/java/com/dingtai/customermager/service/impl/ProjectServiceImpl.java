package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.dao.ProjectEntityMapper;
import com.dingtai.customermager.dao.ProjectInfoMapper;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.db.ProjectEntity;
import com.dingtai.customermager.entity.request.AddProjectReq;
import com.dingtai.customermager.entity.response.GetProjectListResp;
import com.dingtai.customermager.enums.ResultCodeEnum;
import com.dingtai.customermager.exceptions.TransactionException;
import com.dingtai.customermager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 项目接口实现
 *
 * @author peng.lu
 * @date 2020/2/22
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    /**
     * 项目信息Mapper
     */
    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    /**
     * 项目实体Mapper
     */
    @Autowired
    private ProjectEntityMapper projectEntityMapper;

    @Override
    public Result<GetProjectListResp> getProjectById(Long Id) {
        return null;
    }

    /**
     * 根据项目名称获取项目信息
     *
     * @param name 项目名称
     * @return
     */
    @Override
    public Result<GetProjectListResp> queryProjectByName(String name) {

        Result result = null;
        GetProjectListResp projectInfo = projectInfoMapper.queryProjectByName(name);
        if (projectInfo != null) {
            result = new Result(projectInfo);
        }
        return result;
    }

    /**
     * 新增项目
     *
     * @param addProjectReq 请求实体
     * @return Result实体
     */
    @Override
    public Result addProject(AddProjectReq addProjectReq) {
        Result result;
        //用户名
        String projectName = addProjectReq.getProjectName();

        GetProjectListResp projectInfo = projectInfoMapper.queryProjectByName(projectName);
        if(projectInfo != null) {
            return new Result(ResultCodeEnum.APPEND_DATA_ERROR, "当前项目已经存在!");
        }

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setName(projectName);
        int addProject = projectEntityMapper.insert(projectEntity);
        if (addProject <= 0) {
            throw new TransactionException(ResultCodeEnum.APPEND_DATA_ERROR, "新增项目表失败！");
        }
        result = new Result();
        return result;
    }
}
