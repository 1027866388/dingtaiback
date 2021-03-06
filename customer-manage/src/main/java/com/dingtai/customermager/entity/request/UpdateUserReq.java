package com.dingtai.customermager.entity.request;

import com.dingtai.customermager.constants.RegexConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;
import java.util.List;


/**
 * 更新用户请求实体
 *
 * @author wangyanhui
 * @date 2018-04-09 11:53
 */
public class UpdateUserReq {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id", name = "userId", required = true)
    @Min(0)
    @NotNull
    private Long userId;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名", name = "realName", required = true)
    @Size(min = 2, max = 50, message = "真实姓名长度在2到50之间")
    @NotBlank(message = "真实姓名不能为空")
    @Pattern(regexp = RegexConstant.REGEX_NAME, message = "姓名只能包含中英文,最后可以是数字，如张三，张三1")
    private String realName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", name = "mobile", required = true)
    @Pattern(regexp = RegexConstant.REGEX_MOBILE, message = "手机号码格式不正确")
    @NotBlank(message = "手机号码不能为空")
    private String mobile;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", name = "email", required = true)
    @Email(message = "错误的邮箱格式")
    @Size(min = 2, max = 100, message = "邮箱长度在2到100之间")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id", name = "roleId", required = true)
    @NotNull
    private List<Long> roleId;

    /**
     * 组织id
     */
    @ApiModelProperty(value = "组织id", name = "orgId", required = false)
    @Min(0)
    private Long orgId;

    /**
     * OA账号
     */
    @ApiModelProperty(value = "OA账号", name = "oaId", required = false)
    @Size(max = 100, message = "oa账号长度不能超过100")
    private String oaId;

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

    public List<Long> getRoleId() {
        return roleId;
    }

    public void setRoleId(List<Long> roleId) {
        this.roleId = roleId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOaId() {
        return oaId;
    }

    public void setOaId(String oaId) {
        this.oaId = oaId;
    }

}
