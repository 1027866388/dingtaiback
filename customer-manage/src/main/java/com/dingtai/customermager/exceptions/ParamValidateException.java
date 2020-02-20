package com.dingtai.customermager.exceptions;

/**
 * 自定义validator失败会抛出的异常
 *
 * @author wangyanhui
 * @date 2018-04-03 20:44
 */
public class ParamValidateException extends RuntimeException {

    private static final long serialVersionUID = 2876693593755916603L;
    /**
     * 被检验的对象
     */
    private Object object;

    public ParamValidateException(Object object, String message) {
        super(message);
        this.object = object;
    }
}