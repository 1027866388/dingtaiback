package com.dingtai.customermager.controller;

import com.dingtai.customermager.entity.response.ZtreeResp;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.response.GetPermissionTreeResp;
import com.dingtai.customermager.entity.response.ListPermissionResp;
import com.dingtai.customermager.service.PermissionService;
import com.dingtai.customermager.utils.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 权限Controller
 *
 * @author wangyanhui
 * @date 2018-04-15 7:20
 */
@RestController
@RequestMapping(value = "/permission")
@Api(description = "权限接口")
public class PermissionController {


    /**
     * 权限接口
     */
    @Autowired
    private PermissionService permissionService;
    /**
     * 日志
     */
    private static Logger log = LogUtil.get();

    /**
     * 获取权限树
     *
     * @return Result实体
     */
    @GetMapping("/treePerms")
    @ApiOperation(value = "获取权限树", httpMethod = "GET")
    public Result<List<ZtreeResp>> treePerms() {
        return permissionService.treePerms();
    }

    /**
     * 获取当前用户权限列表
     *
     * @return Result实体
     */
    @GetMapping("/getUserPermissionList")
    @ApiOperation(value = "获取当前用户权限列表", httpMethod = "GET")
    public Result<List<ListPermissionResp>> getUserPermissionList() {

        List<GetPermissionTreeResp> userPermissionList = permissionService.getUserPermissionList();
        return new Result(userPermissionList);
    }
}
