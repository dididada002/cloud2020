package com.jt.springcloud.modul.vo;

import java.util.ArrayList;
import java.util.List;

/**
*  Created by liujuan on  2018/12/24
*/
public enum ErrorCode {

    ERROR_100001(100001, "手机号已经存在"),
    ERROR_100002(100002,"端口数量超出合伙人可使用数量"),
    ERROR_100003(100003,"用户已经存在"),
    ERROR_100004(100004,"您所报备的客户已被他人报备"),
    ERROR_100005(100005,"手机号不能为空"),
    ERROR_100006(100006,"合伙人不存在"),
    ERROR_100007(100007,"端口数量不能小于原有数量"),
    ERROR_100008(100008,"验证码无效"),
    ERROR_100009(100009,"空间套餐已存在"),
    ERROR_100010(100010,"确认失败，请检查商品是否已全部发货"),
    ERROR_100011(100011,"未知异常");
    /**
     * 编码
     */
    private Integer code;


    /**
     * 消息
     */
    private String message;


    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public Integer code() {
        return this.code;
    }


    public String message() {
        return this.message;
    }


    public static Integer getCode(String name) {
        for (ErrorCode resultCode : ErrorCode.values()) {
            if (resultCode.name().equals(name)) {
                return resultCode.code;
            }
        }
        return null;
    }


    public static String getMessage(String name) {
        for (ErrorCode resultCode : ErrorCode.values()) {
            if (resultCode.name().equals(name)) {
                return resultCode.message;
            }
        }
        return name;
    }


    @Override
    public String toString() {
        return this.name();
    }


    /**
     * 测试编码重复
     *
     * @param args
     */
    public static void main(String[] args) {
        ErrorCode[] ResultCodes = ErrorCode.values();
        List<Integer> list = new ArrayList<Integer>();
        for (ErrorCode resultCode : ResultCodes) {
            if (list.contains(resultCode.code)) {
                System.out.println("编码重复：" + resultCode.code);
            } else {
                list.add(resultCode.code());
            }
        }
    }


}