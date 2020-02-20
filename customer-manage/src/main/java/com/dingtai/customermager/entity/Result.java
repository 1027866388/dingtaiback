package com.dingtai.customermager.entity;

import com.dingtai.customermager.enums.ResultCodeEnum;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Rest接口返回实体
 *
 * @author wangyanhui
 * @date 2017-09-01 9:39
 */
public class Result<T> {

    /**
     * 结果码
     */
    private Integer status;

    /**
     * 成功时返回的数据
     */
    private T data;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回时间
     */
    private String respTime;

    /**
     * 成功时的构造器
     */
    public Result() {
        this.status = ResultCodeEnum.OPERATION_SUCCESS.key();
        this.setMsg(ResultCodeEnum.OPERATION_SUCCESS.desc());
    }

    /**
     * 成功时的构造器
     */
    public Result(T data) {
        this.data = data;
        this.status = ResultCodeEnum.OPERATION_SUCCESS.key();
        this.setMsg(ResultCodeEnum.OPERATION_SUCCESS.desc());
    }

    /**
     * 错误时的构造器
     */
    public Result(ResultCodeEnum resultCodeEnum, String errorMsg) {
        this.status = resultCodeEnum.key();
        if (StringUtils.isEmpty(errorMsg)) {
            this.msg = resultCodeEnum.desc();
        } else {
            this.msg = errorMsg;
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRespTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String resTime = LocalDateTime.now().format(dateTimeFormatter);
        return resTime;
    }

    public void setRespTime(String respTime) {
        this.respTime = respTime;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                ", respTime='" + respTime + '\'' +
                '}';
    }
}
