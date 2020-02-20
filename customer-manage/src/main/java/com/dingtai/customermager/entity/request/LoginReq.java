package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * 登录请求实体
 *
 * @author vic
 * @date 2018-03-29 16:21
 */
@ApiModel(value = "LoginReq", description = "登录请求实体")
public class LoginReq {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "userName", required = true)
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", name = "password", required = true)
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 验证码
     */
    @ApiModelProperty(value = "验证码", name = "captcha", required = true)
    private String captcha;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
