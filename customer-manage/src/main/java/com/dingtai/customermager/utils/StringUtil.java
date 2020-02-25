package com.dingtai.customermager.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义String工具类
 *
 * @author wangyanhui
 * @date 2017-09-01 10:29
 */
public class StringUtil extends StringUtils {
    public static final String EMPTY = "";
    /**
     * 正整数或者负整数
     */
    private static Pattern posIntPattern = Pattern.compile("^\\d+$|-\\d+$");
    /**
     * 正小数或者负小数
     */
    private static Pattern posDecimalPattern = Pattern.compile("\\d+\\.\\d+$|-\\d+\\.\\d+$");

    private static Pattern posScientificPattern = Pattern.compile("^((-?\\d+.?\\d*)[Ee]{1}(-?\\d+))$");
    

    /**
     * 判断是否是整数或小数
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        //整数的校验
        Matcher posIntMatch = posIntPattern.matcher(str);
        //小数的校验
        Matcher posDecimalMatch = posDecimalPattern.matcher(str);
        //科学计数法的校验
        Matcher posScientificMatch = posScientificPattern.matcher(str);
        if (posIntMatch.matches() == false && posDecimalMatch.matches() == false && posScientificMatch.matches() == false) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * 字母由大写转化为小写
     *
     * @param str
     * @return
     */
    public static String replaceAlphabet(String str) {
        String ra = str.toLowerCase();
        return ra;
    }

    /**
     * 校验数据是否是字母
     *
     * @param str
     * @return
     */
    public static Boolean checkAlphabet(String str) {
        Boolean flag = str.matches("^[a-zA-Z]*");
        return flag;
    }

    /**
     * 截取字符串8位
     *
     * @param str
     * @return
     */
    public static String cutField(String str) {
        int min = 8;
        if (str.length() > min) {
            str = str.substring(0, 8);
        }
        return str;
    }
}
