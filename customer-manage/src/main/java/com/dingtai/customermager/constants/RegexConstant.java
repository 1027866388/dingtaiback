package com.dingtai.customermager.constants;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2019-03-27 16:26
 *  
 */
public class RegexConstant {
    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^1[3|4|5|7|8][0-9]\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 密码规则
     */
    public static final String REGEX_PASSWORD = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*()])[\\da-zA-Z!@#$%^&*]{8,50}$";

    /**
     * 姓名校验
     */
    public static final String REGEX_NAME = "^[\\u4E00-\\u9FA5A-Za-z]+[1-9]*$";


}
