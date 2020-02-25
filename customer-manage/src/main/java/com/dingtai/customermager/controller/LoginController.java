package com.dingtai.customermager.controller;

import com.alibaba.fastjson.JSON;
import com.dingtai.customermager.constants.DateTimeConstant;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.LoginReq;
import com.dingtai.customermager.service.LoginService;
import com.dingtai.customermager.utils.DataValidator;
import com.dingtai.customermager.utils.LogUtil;
import com.dingtai.customermager.utils.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * 登录控制类
 *
 * @author wangyanhui
 * @date 2018-04-02 11:55
 */
@RestController
@RequestMapping(value = "/login")
@Api(description = "登录接口")
public class LoginController {

    /**
     * 日志
     */
    private static Logger logger = LogUtil.get();

    /**
     * 图片生产者
     */
    @Autowired
    private LoginService loginService;


    /**
     * 生成验证码
     *
     * @param response 返回实体
     * @throws ServletException Servlet异常
     * @throws IOException      IO异常
     */
    @GetMapping("captcha")
    @ApiOperation(value = "生成验证码")
    public void captcha(HttpServletResponse response) throws IOException {
        loginService.captcha(response);
    }

    /**
     * 登录接口
     *
     * @param request 请求实体
     * @return 返回实体
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录", httpMethod = "POST")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = DateTimeConstant.MINUTE_S, rollbackFor = Exception.class)
    public Result login(@RequestBody @Valid LoginReq request) {
        logger.info("登录，请求", JSON.toJSONString(request));
        DataValidator.isNull(request, "登录接口，请求参数不能为空！");
        DataValidator.isBlank(request.getCaptcha(), "验证码必传！");
        Result result = loginService.login(request);
        logger.info("登录，响应result:{}", JSON.toJSONString(result));
        return result;
    }
    /**
     * 注销
     *
     * @return 返回实体
     */
    @GetMapping(value = "/logout")
    @ApiOperation(value = "注销", httpMethod = "GET")
    public Result logout() {
        ShiroUtils.logout();
        return new Result();
    }
}
