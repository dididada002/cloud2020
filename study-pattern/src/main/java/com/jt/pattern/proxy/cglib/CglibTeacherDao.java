package com.jt.pattern.proxy.cglib;

/**
 * @author: jingteng
 * @date: 2020/6/11 1:44
 */
public class CglibTeacherDao {
    public void teach(String content){
        System.out.println("Cglib 老师正在教授："+content);
    }
}
