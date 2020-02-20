package com.dingtai.customermager.controller;

import com.dingtai.customermager.constants.DateTimeConstant;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.AddRoleReq;
import com.dingtai.customermager.entity.request.GetRoleListReq;
import com.dingtai.customermager.entity.request.UpdateRoleReq;
import com.dingtai.customermager.entity.response.GetRoleInfoResp;
import com.dingtai.customermager.entity.response.GetRoleListResp;
import com.dingtai.customermager.enums.ResultCodeEnum;
import com.dingtai.customermager.service.RoleService;
import com.dingtai.customermager.utils.DataValidator;
import com.dingtai.customermager.utils.LogUtil;
import com.dingtai.customermager.utils.ShiroUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 角色Controller
 *
 * @author wangyanhui
 * @date 2018-04-10 21:32
 */
@RestController
@RequestMapping(value = "/role")
@Api(description = "角色接口")
public class RoleController {
    /**
     * 日志
     */
    private static Logger log = LogUtil.get();

    /**
     * 角色接口
     */
    @Autowired
    private RoleService roleService;

    /**
     * 获取角色列表
     *
     * @param request 请求实体
     * @return Result实体
     */
    @GetMapping("/listRoleInfo")
    @ApiOperation(value = "获取角色列表", httpMethod = "GET")
    @RequiresPermissions("sys:role")
    public Result<PageInfo<GetRoleListResp>> listRoleInfo(GetRoleListReq request) {
        DataValidator.isNull(request, "获取角色列表接口，请求参数不能为空！");
        return roleService.listRoleInfo(request);
    }

    @GetMapping("/getRoleInfoByRoleId")
    @ApiOperation(value = "根据角色id获取角色信息", httpMethod = "GET")
    @RequiresPermissions("sys:role")
    public Result<GetRoleInfoResp> getRoleInfoByRoleId(@ApiParam(name = "roleId", value = "角色id", required = true) @RequestParam Long roleId) {
        DataValidator.isNull(roleId, "根据角色id获取角色信息接口，角色id不能为空！");
        return roleService.getRoleInfoByRoleId(roleId);
    }

    /**
     * 新增角色
     *
     * @param request 请求实体
     * @return Result实体
     */
    @PostMapping("/addRole")
    @ApiOperation(value = "新增角色", httpMethod = "POST")
    @RequiresPermissions("sys:role:create")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = DateTimeConstant.MINUTE_S, rollbackFor = Exception.class)
    public Result addUser(@RequestBody @Valid AddRoleReq request) {

        //获取用户id
        Long userId = ShiroUtils.getUserId();
        if (userId == null || userId == 0) {
            return new Result(ResultCodeEnum.APPEND_DATA_ERROR, "用户id为空！");
        }
        return roleService.addRole(request, userId);
    }

    /**
     * 修改角色
     *
     * @param request 请求实体
     * @return Result实体
     */
    @PostMapping("/updateRole")
    @ApiOperation(value = "修改角色", httpMethod = "POST")
    @RequiresPermissions("sys:role:edit")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = DateTimeConstant.MINUTE_S, rollbackFor = Exception.class)
    public Result updateRole(@RequestBody @Valid UpdateRoleReq request) throws Exception {

        return roleService.updateRole(request);
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    @PostMapping("/deleteRole")
    @ApiOperation(value = "删除角色", httpMethod = "POST")
    @RequiresPermissions("sys:role:delete")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = DateTimeConstant.MINUTE_S, rollbackFor = Exception.class)
    public Result deleteRole(@ApiParam(name = "roleId", value = "角色id", required = true) @RequestParam Long roleId) {
        DataValidator.isNull(roleId, "角色id不能为空");
        return roleService.deleteRole(roleId);
    }

    /**
     * 获取角色人员
     *
     * @param roleName 角色名称
     * @return
     */
    @GetMapping("/getUserNameByRole")
    @ApiOperation(value = "通过名称查询角色", httpMethod = "GET")
    public Result selectUserNameByRole(@ApiParam(name = "roleName", value = "角色名称", required = true) @RequestParam String roleName) {
        DataValidator.isNull(roleName, "角色名称不能为空");
        return roleService.selectUserNameByRole(roleName);
    }

}
