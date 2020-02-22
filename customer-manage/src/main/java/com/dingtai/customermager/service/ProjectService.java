package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.response.GetProjectListResp;

/**
 * 项目接口
 *
 * @author peng.lu
 * @date 2020/2/22
 */
public interface ProjectService {

    /**
     * 根据项目id获取项目
     *
     * @param Id 项目Id
     * @return 项目实体
     */
    Result<GetProjectListResp> getProjectById(Long Id);

    /**
     * 通过项目名获取项目信息
     *
     * @param name 项目名称
     * @return 项目信息
     */
    Result<GetProjectListResp> queryProjectByName(String name);
}
