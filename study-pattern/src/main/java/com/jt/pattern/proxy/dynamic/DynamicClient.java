package com.jt.pattern.proxy.dynamic;

import com.jt.pattern.proxy.staticproxy.ITeachetDao;
import com.jt.pattern.proxy.staticproxy.TeacherDao;

/**
 * @author: jingteng
 * @date: 2020/6/11 1:22
 */
public class DynamicClient {
    public static void main(String[] args) {
        //1、创建被代理对象
        ITeachetDao teacherDao = new TeacherDao();
        //2、根据被代理对象获取代理对象
        ITeachetDao proxyInstance = (ITeachetDao) new DynamicProxyFactory(teacherDao).getProxyInstance();

        //打印结果：proxyInstance= class com.sun.proxy.$Proxy0，表明内存中动态生成了代理对象
        System.out.println("proxyInstance= " + proxyInstance.getClass());

        //3、通过代理对象，调用被代理对象的方法
        proxyInstance.teach();
    }
}
