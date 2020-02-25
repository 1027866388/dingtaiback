package com.dingtai.customermager.entity.request;

/**
 * 获取用户列表请求实体
 *
 * @author wangyanhui
 * @date 2018-03-19 12:20
 */
public class GetUserListReq extends BasePageReq {
    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 用户名
     */
    private String userName;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "GetUserListReq{" + "realName='" + realName + '\'' + ", mobile='" + mobile + '\'' + ", userName='" + userName + '\'' + "} " + super.toString();
    }
}
