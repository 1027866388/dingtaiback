package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * 新增项目请求实体
 *
 * TODO 项目字段后续等待补充
 * @author peng.lu
 * @date 2020/2/23
 */
public class AddProjectReq {

    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称", name = "projectName", required = true)
    @NotBlank(message = "项目名称不能为空")
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
