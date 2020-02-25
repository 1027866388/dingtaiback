package com.dingtai.customermager.service.impl;


import com.dingtai.customermager.service.LoginService;
import com.dingtai.customermager.service.UserService;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.LoginReq;
import com.dingtai.customermager.enums.ResultCodeEnum;
import com.dingtai.customermager.utils.AesUtil;
import com.dingtai.customermager.utils.LogUtil;
import com.dingtai.customermager.utils.ShiroUtils;
import com.github.pagehelper.util.StringUtil;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *  登录
 *  
 *  @author wangyanhui
 *  @date 2018-09-17 15:12
 *  
 */
@Service
public class LoginServiceImpl implements LoginService {

    /**
     * 日志
     */
    private static Logger log = LogUtil.get();

    /**
     * 图片生产者
     */
    @Autowired
    private Producer producer;

    @Value("${AppKey.passwordAesKey}")
    private String passwordAesKey;


    /**
     * 用户接口
     */
    @Resource
    private UserService userService;

    /**
     * 生成验证码
     *
     * @param response 返回实体
     * @throws IOException
     */
    @Override
    public void captcha(HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    /**
     * 登录
     *
     * @param request 请求实体
     * @return
     */
    @Override
    public Result login(LoginReq request) {
        Result result;
        try {
            int type = 0;

            String captcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
            if (StringUtil.isEmpty(captcha)) {
                return new Result(ResultCodeEnum.QUERY_DATA_ERROR, "验证码过期，请刷新！");
            }
            if (!request.getCaptcha().equalsIgnoreCase(captcha)) {
                return new Result(ResultCodeEnum.QUERY_DATA_ERROR, "验证码不正确");
            }
            Subject subject = ShiroUtils.getSubject();
            String password = AesUtil.getAesAndMd5Str(request.getPassword(), passwordAesKey);
            UsernamePasswordToken token = new UsernamePasswordToken(request.getUserName(), password);
            subject.logout();
            subject.login(token);
            //更新用户表最后登录时间
            userService.updateLastLoginTime(ShiroUtils.getUserId());
            result = new Result();
        } catch (UnknownAccountException e) {
            log.error(e.getMessage(), e);
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, e.getMessage());
        } catch (IncorrectCredentialsException e) {
            log.error("账号或密码不正确", e);
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, "账号或密码不正确");
        } catch (LockedAccountException e) {
            log.error("输错五次以上密码，账号已被锁定,请联系管理员", e);
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, "输错五次以上密码，账号已被锁定,请联系管理员");
        } catch (AuthenticationException e) {
            log.error("账户验证失败", e);
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, "账户验证失败");
        }
        return result;
    }

    /**
     * 登录无需验证码
     *
     * @param request 请求实体
     * @return
     */
    @Override
    public Result loginNoCaptcha(LoginReq request) {
        Result result;
        try {
            Subject subject = ShiroUtils.getSubject();
            String password = AesUtil.getAesAndMd5Str(request.getPassword(), passwordAesKey);
            UsernamePasswordToken token = new UsernamePasswordToken(request.getUserName(), password);
            subject.login(token);
            //更新用户表最后登录时间
            Integer updateLastLoginTime = userService.updateLastLoginTime(ShiroUtils.getUserId());
            if (updateLastLoginTime <= 0) {
                return new Result(ResultCodeEnum.QUERY_DATA_ERROR, "更新最后登录时间失败！");
            }
            result = new Result();
        } catch (UnknownAccountException e) {
            log.error(e.getMessage(), e);
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, e.getMessage());
        } catch (IncorrectCredentialsException e) {
            log.error("账号或密码不正确", e);
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, "账号或密码不正确");
        } catch (LockedAccountException e) {
            log.error("账号已被锁定,请联系管理员", e);
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, "账号已被锁定,请联系管理员");
        } catch (AuthenticationException e) {
            log.error("账户验证失败", e);
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, "账户验证失败");
        }
        return result;
    }

    /**
     * 登录无需验证码
     *
     * @param request 请求实体
     * @return
     */
    @Override
    public Result loginNoCaptchaEncryPass(LoginReq request) {
        Result result;
        try {
            Long userId = ShiroUtils.getUserId();
            if (userId != null && userId > 0) {
                result = new Result();
                return result;
            }
            Subject subject = ShiroUtils.getSubject();
            String password = AesUtil.getAesAndMd5Str(request.getPassword(), passwordAesKey);
            UsernamePasswordToken token = new UsernamePasswordToken(request.getUserName(), password);
            subject.login(token);

            //更新用户表最后登录时间
            Integer updateLastLoginTime = userService.updateLastLoginTime(ShiroUtils.getUserId());
            if (updateLastLoginTime <= 0) {
                return new Result(ResultCodeEnum.QUERY_DATA_ERROR, "更新最后登录时间失败！");
            }
            result = new Result();
        } catch (UnknownAccountException e) {
            log.error(e.getMessage(), e);
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, e.getMessage());
        } catch (IncorrectCredentialsException e) {
            log.error("账号或密码不正确", e);
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, "账号或密码不正确");
        } catch (LockedAccountException e) {
            log.error("账号已被锁定,请联系管理员", e);
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, "账号已被锁定,请联系管理员");
        } catch (AuthenticationException e) {
            log.error("账户验证失败", e);
            result = new Result(ResultCodeEnum.QUERY_DATA_ERROR, "账户验证失败");
        }
        return result;
    }
}
