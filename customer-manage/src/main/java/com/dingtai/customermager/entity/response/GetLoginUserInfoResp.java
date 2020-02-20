package com.dingtai.customermager.entity.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * 获取登录用户信息
 *
 * @author wangyanhui
 * @date 2018-04-25 11:12
 */
public class GetLoginUserInfoResp {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id", name = "userId")
    private Long userId;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名", name = "realName")
    private String realName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", name = "mobile")
    private String mobile;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", name = "email")
    private String email;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "userName")
    private String userName;

    /**
     * 令牌
     */
    @ApiModelProperty(value = "令牌", name = "token")
    private String token;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
