package com.jt.pattern.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: jingteng
 * @date: 2020/6/11 1:46
 */
public class CglibProxyFactory implements MethodInterceptor {

    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        //1、创建一个工具类
        Enhancer enhancer = new Enhancer();
        //2、设置父类
        enhancer.setSuperclass(target.getClass());
        //3、设置回调函数
        enhancer.setCallback(this);
        //4、创建子类对象，即代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib 代理模式开始。。。");
        Object returnVal = method.invoke(target, args);
        System.out.println("Cglib 代理模式结束。。。");
        return returnVal;
    }
}
