package com.dingtai.customermager.controller;
import com.dingtai.customermager.constants.DateTimeConstant;
import com.dingtai.customermager.constants.PermissionConstant;
import com.dingtai.customermager.constants.RegexConstant;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.response.GetLoginUserInfoResp;
import com.dingtai.customermager.entity.response.GetUserListResp;
import com.dingtai.customermager.enums.ResultCodeEnum;
import com.dingtai.customermager.service.UserService;
import com.dingtai.customermager.utils.DataValidator;
import com.dingtai.customermager.utils.LogUtil;
import com.dingtai.customermager.utils.ShiroUtils;
import com.dingtai.customermager.entity.db.UserEntity;
import com.dingtai.customermager.entity.request.AddUserReq;
import com.dingtai.customermager.entity.request.GetUserListReq;
import com.dingtai.customermager.entity.request.UpdatePwdReq;
import com.dingtai.customermager.entity.request.UpdateUserReq;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.Objects;


/**
 * 用户控制
 *
 * @author wangyanhui
 * @date 2017-09-01 10:29
 */
@RestController
@RequestMapping(value = "/user")
@Api(description = "用户接口")
public class UserController {
    /**
     * 日志
     */
    private static Logger log = LogUtil.get();

    /**
     * 用户接口
     */
    @Resource
    private UserService userService;


    /**
     * 获取用户列表
     *
     * @param request 请求实体
     * @return Result实体
     */
    @GetMapping("/listUserInfo")
    @ApiOperation(value = "获取用户列表", httpMethod = "GET")
    @RequiresPermissions("sys:user")
    public Result<PageInfo<GetUserListResp>> listUserInfo(GetUserListReq request) {
        DataValidator.isNull(request, "获取用户列表接口，请求参数不能为空！");

        Result result = userService.listUserInfo(request);
        return result;
    }

    /**
     * 获取登录的用户信息
     *
     * @return Result实体
     */
    @GetMapping("/getLoginUserInfo")
    @ApiOperation(value = "获取登录的用户信息", httpMethod = "GET")
    public Result<GetLoginUserInfoResp> getLoginUserInfo() {
        Result result = null;
        GetLoginUserInfoResp getLoginUserInfoResp = new GetLoginUserInfoResp();
        UserEntity userEntity = ShiroUtils.getUserEntity();
        if (userEntity != null) {
            getLoginUserInfoResp.setUserId(userEntity.getId());
            getLoginUserInfoResp.setEmail(userEntity.getEmail());
            getLoginUserInfoResp.setUserName(userEntity.getUserName());
            getLoginUserInfoResp.setMobile(userEntity.getMobile());
            getLoginUserInfoResp.setRealName(userEntity.getRealName());
            Serializable token = ShiroUtils.getSession().getId();
            getLoginUserInfoResp.setToken((String) token);
            result = new Result<>(getLoginUserInfoResp);
        }
        return result;
    }

    /**
     * 根据用户id获取用户
     *
     * @param userId 用户id
     * @return Result实体
     */
    @GetMapping("/getUserByUserId")
    @ApiOperation(value = "根据用户id获取用户", httpMethod = "GET")
    @RequiresPermissions("sys:user")
    public Result<GetUserListResp> getUserByUserId(@ApiParam(name = "userId", value = "用户id", required = true) @RequestParam Long userId) {
        DataValidator.isNull(userId, "根据用户id获取用户接口，请求参数不能为空！");
        return userService.getUserByUserId(userId);
    }

    /**
     * 新增用户
     *
     * @param request 请求实体
     * @return Result实体
     */
    @PostMapping("/addUser")
    @ApiOperation(value = "新增用户", httpMethod = "POST")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = DateTimeConstant.MINUTE_S, rollbackFor = Exception.class)
    @RequiresPermissions("sys:user:create")
    public Result addUser(@RequestBody @Valid AddUserReq request) {

        DataValidator.size(request.getUserName(), 2, 50, "用户名长度在2到50之间");
        return userService.addUser(request);
    }

    /**
     * 更新用户
     *
     * @param request 请求实体
     * @return Result实体
     */
    @PostMapping("/updateUser")
    @ApiOperation(value = "更新用户", httpMethod = "POST")
    @RequiresPermissions("sys:user:edit")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = DateTimeConstant.MINUTE_S, rollbackFor = Exception.class)
    public Result updateUser(@RequestBody @Valid UpdateUserReq request) {

        return userService.updateUser(request);
    }

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return Result实体
     */
    @PostMapping("/deleteUser")
    @ApiOperation(value = "删除用户", httpMethod = "POST")
    @RequiresPermissions("sys:user:delete")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = DateTimeConstant.MINUTE_S, rollbackFor = Exception.class)
    public Result deleteUser(@ApiParam(name = "userId", value = "用户id", required = true) @RequestParam Long userId) {
        DataValidator.isNull(userId, "删除用户接口，请求参数不能为空！");
        if (Objects.equals(userId, PermissionConstant.SUPER_ADMIN_USER_ID)) {
            return new Result(ResultCodeEnum.DELETE_DATA_ERROR, "系统管理员不能删除！");
        }
        if (userId.equals(ShiroUtils.getUserId())) {
            return new Result(ResultCodeEnum.DELETE_DATA_ERROR, "当前用户不能删除！");
        }
        return userService.deleteUser(userId);
    }

    /**
     * 修改密码
     *
     * @param request 请求实体
     * @return Result实体
     */
    @PostMapping("/updatePassword")
    @ApiOperation(value = "修改密码", httpMethod = "POST")
    public Result updatePassword(@RequestBody @Valid UpdatePwdReq request) {

        DataValidator.size(request.getNewPassword(), 8, 50, "新密码长度在8到50之间");
        DataValidator.patten(request.getNewPassword(), RegexConstant.REGEX_PASSWORD, "密码应为8-50个大小写字母、数字和特殊字符的组合，特殊字符范围：!@#$%^&*");
        if (Objects.equals(request.getUserId(), PermissionConstant.SUPER_ADMIN_USER_ID)) {
            return new Result(ResultCodeEnum.MODIFY_DATA_ERROR, "系统管理员密码不能修改！");
        }
        Result result = userService.updatePassword(request);
        //修改密码成功，注销用户
        if (result.getStatus().equals(ResultCodeEnum.OPERATION_SUCCESS.key())) {
            ShiroUtils.logout();
        }
        return result;
    }


}

