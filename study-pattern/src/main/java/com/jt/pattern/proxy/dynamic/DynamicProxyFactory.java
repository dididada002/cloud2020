package com.jt.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: jingteng
 * @date: 2020/6/11 1:10
 * 根据被代理对象生成相应的代理对象
 */
public class DynamicProxyFactory {

    //被代理对象
    private Object target;

    public DynamicProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象生成一个代理对象
    public Object getProxyInstance(){

        /**
         * Object newProxyInstance(ClassLoader loader,
         *                                           Class<?>[] interfaces,
         *                                           InvocationHandler h)
         *
         * 这个方法的参数：
         *      ClassLoader：指定当前目标对象使用的类加载器，获取加载器的方法固定
         *      Class<?>[]：目标对象实现的接口类型，使用泛型方法确认类型
         *      InvocationHandler：事件处理，执行目标对象的方法时，
         *                      会触发事件处理器方法，把当前执行的目标对象方法作为参数传入
         *
         * */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK代理开始。。。");
                        //反射机制调用目标对象的方法
                        Object returnVal = method.invoke(target, args);
                        System.out.println("JDK代理结束。。。");
                        return returnVal;
                    }
                });
    }
}
