package com.jt.pattern.proxy.cglib;

/**
 * @author: jingteng
 * @date: 2020/6/11 1:55
 */
public class CglibClient {
    public static void main(String[] args) {
        //1、创建目标对象
        CglibTeacherDao target = new CglibTeacherDao();

        //2、获取代理对象
        CglibTeacherDao proxyInstance = (CglibTeacherDao) new CglibProxyFactory(target).getProxyInstance();
        //3、执行代理对象的方法，会触发intercept方法，从而实现对目标对象的调用
        proxyInstance.teach("设计模式--cglib 代理");
    }
}
