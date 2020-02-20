package com.dingtai.customermager.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志封装类
 *
 * @author wangyanhui
 * @date 2017-09-21 13:43
 */
public class LogUtil {

    public final static String ELAPSE_TIME="，耗时：{}ms";
    public static Logger get(){
        StackTraceElement[] stackTrace=Thread.currentThread().getStackTrace();
        return LoggerFactory.getLogger(stackTrace[2].getClassName());
    }
}
