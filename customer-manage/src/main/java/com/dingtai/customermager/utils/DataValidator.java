package com.dingtai.customermager.utils;

import com.dingtai.customermager.exceptions.ParamValidateException;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

/**
 * 数据校验
 *
 * @author wangyanhui
 * @date 2018-4-3 11:28
 */
public class DataValidator {

    /**
     * 判断参数是否为空或空字符串
     *
     * @param str     参数名称
     * @param message 错误信息
     */
    public static void isBlank(String str, String message) {
        if (StringUtils.isEmpty(str)) {
            throw new ParamValidateException(str, message);
        }
    }

    /**
     * 判断对象是否为空
     *
     * @param object  对象
     * @param message 错误信息
     */
    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new ParamValidateException(null, message);
        }
    }

    /**
     * 判断字符串长度
     *
     * @param str
     * @param min
     * @param max
     * @param message
     */
    public static void size(String str, int min, int max, String message) {
        if (str.length() < min || str.length() > max) {
            throw new ParamValidateException(null, message);
        }
    }

    /**
     * 判断是否符合正则表达式
     *
     * @param str
     * @param message
     */
    public static void patten(String str, String patten, String message) {
        boolean isMatch = Pattern.matches(patten, str);
        if (!isMatch) {
            throw new ParamValidateException(null, message);
        }
    }
}
