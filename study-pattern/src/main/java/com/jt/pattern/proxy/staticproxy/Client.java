package com.jt.pattern.proxy.staticproxy;

/**
 * @author: jingteng
 * @date: 2020/6/11 0:54
 */
public class Client {
    public static void main(String[] args) {
        //1、创建被代理对象
        TeacherDao teacherDao = new TeacherDao();
        //2、创建代理对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);
        //3、通过代理对象，调用被代理对象的方法
        teacherDaoProxy.teach();
    }
}
