package com.dingtai.customermager.exceptions;

import com.dingtai.customermager.enums.ResultCodeEnum;

/**
 * 验证异常
 *
 * @author wangyanhui
 * @date 2017-09-19 9:39
 */
public class VerificationException extends RuntimeException {


    private static final long serialVersionUID = 1199374400257151833L;
    /**
     * 异常代码
     */
    private ResultCodeEnum code;

    /**
     * 异常说明
     */
    private String desc;


    public VerificationException() {
        super();
    }


    public VerificationException(String message) {
        super(message);
        this.desc = message;
    }


    public VerificationException(ResultCodeEnum code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public VerificationException(ResultCodeEnum code, String desc, Throwable cause) {
        super(cause);
        this.code = code;
        this.desc = desc;
    }


    public VerificationException(ResultCodeEnum code, String desc, String message) {
        super(message);
        this.code = code;
        this.desc = desc;
    }


    public ResultCodeEnum getCode() {
        return code;
    }


    public String getDesc() {
        return desc;
    }


    @Override
    public String getMessage() {
        if (super.getMessage() == null) {
            return desc;
        }
        return super.getMessage();
    }
}
