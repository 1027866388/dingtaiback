package com.dingtai.customermager.dao;

import com.dingtai.customermager.entity.response.GetProjectListResp;

/**
 * 项目信息mapper
 *
 * @author peng.lu
 * @date 2020/2/22
 */
public interface ProjectInfoMapper {

    /**
     * 根据项目名称查询项目信息
     *
     * @param name 项目名称
     * @return 项目信息
     */
    GetProjectListResp queryProjectByName(String name);
}
