package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.dao.ProjectInfoMapper;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.response.GetProjectListResp;
import com.dingtai.customermager.entity.response.GetUserListResp;
import com.dingtai.customermager.enums.ResultCodeEnum;
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

        Result result;
        GetProjectListResp projectInfo = projectInfoMapper.queryProjectByName(name);
        if (projectInfo != null) {
            result = new Result(projectInfo);
        } else {
//            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, "查询数据为空！");
            result = null;
        }
        return result;
    }
}
