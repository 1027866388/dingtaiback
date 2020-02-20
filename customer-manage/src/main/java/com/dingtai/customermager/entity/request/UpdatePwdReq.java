package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 修改密码请求实体
 *
 * @author wangyanhui
 * @date 2018-04-10 11:23
 */
public class UpdatePwdReq {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id", name = "userId", required = true)
    @NotNull
    private Long userId;

    /**
     * 密码
     */
    @ApiModelProperty(value = "旧密码", name = "oldPassword", required = true)
    @NotBlank(message = "旧密码不能为空")
    private String oldPassword;

    /**
     * 密码
     */
    @ApiModelProperty(value = "新密码", name = "newPassword", required = true)
    @NotBlank(message = "新密码不能为空")
    private String newPassword;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
