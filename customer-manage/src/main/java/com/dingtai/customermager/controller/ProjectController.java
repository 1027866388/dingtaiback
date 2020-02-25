package com.dingtai.customermager.controller;

import com.dingtai.customermager.constants.DateTimeConstant;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.AddProjectReq;
import com.dingtai.customermager.entity.response.GetProjectListResp;
import com.dingtai.customermager.service.ProjectService;
import com.dingtai.customermager.utils.DataValidator;
import com.dingtai.customermager.utils.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    /**
     * 新增项目
     *
     * @param request 请求实体
     * @return Result实体
     */
    @PostMapping("/addProject")
    @ApiOperation(value = "新增项目", httpMethod = "POST")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = DateTimeConstant.MINUTE_S, rollbackFor = Exception.class)
    public Result addProject(@RequestBody @Valid AddProjectReq request) {

        DataValidator.size(request.getProjectName(), 2, 50, "项目名长度在2到50之间");
        return projectService.addProject(request);
    }
}
