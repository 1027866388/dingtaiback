package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2019-09-09 14:33
 *  
 */
public class ResetPwdReq {


    /**
     * token
     */
    @ApiModelProperty(value = "token", name = "token", required = true)
    @NotNull
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 密码
     */
    @ApiModelProperty(value = "新密码", name = "newPassword", required = true)
    @NotBlank(message = "新密码不能为空")
    private String newPassword;


    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
