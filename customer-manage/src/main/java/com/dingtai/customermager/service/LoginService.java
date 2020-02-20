package com.dingtai.customermager.service;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.LoginReq;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  登录接口
 *  
 *  @author wangyanhui
 *  @date 2018-09-17 15:09
 *  
 */
public interface LoginService {
    /**
     * 生成验证码
     *
     * @param response 返回实体
     * @throws ServletException Servlet异常
     * @throws IOException      IO异常
     */
    public void captcha(HttpServletResponse response) throws IOException;

    /**
     * 登录接口
     *
     * @param request 请求实体
     * @return 返回实体
     */
    public Result login(LoginReq request);

    /**
     * 登录无需验证码
     *
     * @param request
     * @return
     */
    public Result loginNoCaptcha(LoginReq request);


    /**
     * 登录无需验证码加密密码
     *
     * @param request
     * @return
     */
    public Result loginNoCaptchaEncryPass(LoginReq request);
}
