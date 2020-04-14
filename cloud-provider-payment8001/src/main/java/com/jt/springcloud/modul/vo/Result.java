package com.jt.springcloud.modul.vo;



import java.io.Serializable;

/**
*  Created by chuzhaowei on  2018/9/13 
*/
public class Result implements Serializable {

    private static final long serialVersionUID = -5372450875750675775L;

    private static final Integer PARAM_ERROR_CODE = 425;

    /**
     * 编码
     */
    private Integer code;


    /**
     * 消息
     */
    private String msg;


    /**
     * 数据
     */
    private Object data;


    public Result() {
    }


    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }


    public static Result success(Object data) {
        Result result = new Result();
        result.setData(data);
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }
    public static Result successBusFail(Object data) {
        Result result = new Result();
        result.setData(data);
        result.setResultCode(ResultCode.FAILURE);
        return result;
    }

    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }


    public void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }

    public static Result failure(ErrorCode errorCode) {
        Result result = new Result();
        result.setErrorCode(errorCode);
        return result;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.code = errorCode.code();
        this.msg = errorCode.message();
    }

    public static Result failureParam(String msg) {
        Result result = new Result();
        result.setCode(PARAM_ERROR_CODE);
        result.setMsg(msg);
        return result;
    }

    public static Result failureWithMsg(String msg) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg(msg);
        return result;
    }

    public Integer getCode() {
        return code;
    }


    public void setCode(Integer code) {
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Object getData() {
        return data;
    }


    public void setData(Object data) {
        this.data = data;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
