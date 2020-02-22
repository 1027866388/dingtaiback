package com.dingtai.customermager.controller;

import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.response.GetProjectListResp;
import com.dingtai.customermager.service.ProjectService;
import com.dingtai.customermager.utils.DataValidator;
import com.dingtai.customermager.utils.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目接口
 *
 * @author peng.lu
 * @date 2020/2/22
 */

@RestController
@RequestMapping(value = "/project")
@Api(description = "项目接口")
public class ProjectController {

    /**
     * 日志
     */
    private static Logger log = LogUtil.get();

    /**
     * 项目接口
     */
    @Autowired
    private ProjectService projectService;

    @GetMapping("/getProjectByName")
    @ApiOperation(value = "根据项目名称获取项目信息", httpMethod = "GET")
    public Result<GetProjectListResp> getProjectByName(@ApiParam(name = "name", value = "项目名称", required = true) @RequestParam String name) {

        DataValidator.isNull(name, "查询项目接口，请求参数不能为空！");
        return projectService.queryProjectByName(name);
    }
}
