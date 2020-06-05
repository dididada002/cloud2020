package com.jt.pattern.singleton;

/**
 * @author: jingteng
 * @date: 2020/5/26 21:16
 *
 */
public class SingletonTest1 {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton2 = Singleton1.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}


/**
 * 单例模式：饿汉式（静态变量） 实现
 * */
class Singleton1{
    public Singleton1() {
    }
    private final static Singleton1 instance = new Singleton1();
    public static Singleton1 getInstance(){
        return instance;
    }
}


/**
 * 单例模式：饿汉式（静态代码块） 实现
 * */
class Singleton2{
    public Singleton2() {
    }
    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }
    public static Singleton2 getInstance(){
        return instance;
    }
}


/**
 * 单例模式：懒汉式（线程不安全）
 * */
class Singleton3{
    private static Singleton3 instance;

    public Singleton3() {

    }

    public static Singleton3 getInstance(){
        if (instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}


/**
 * 单例模式：懒汉式（线程安全，同步方法）
 * */
class Singleton4{
    private static Singleton4 instance;

    public Singleton4() {

    }

    public static synchronized Singleton4 getInstance(){
        if (instance == null){
            instance = new Singleton4();
        }
        return instance;
    }
}


/**
 * Double - Check 实现单例模式
 * volatile禁止指令重排
 * */
class Singleton5{
    private volatile static Singleton5 instance;

    public Singleton5() {

    }

    public static Singleton5 getInstance(){
        if (instance == null){
            synchronized (Singleton5.class){
                if (instance == null){
                    instance = new Singleton5();
                }
            }
        }
        return Singleton5.instance;
    }
}

/**
 * 静态内部类实现单例模式
 * */
class Singleton6{
    public Singleton6() {
    }
    private static class SingletonInnerInstance{
        private volatile static Singleton6 instance = new Singleton6();
    }
    public static synchronized Singleton6 getInstance(){
        return SingletonInnerInstance.instance;
    }
}


/**
 * 枚举 实现单例模式
 * */
class Singleton7{
    public Singleton7() {

    }
    private enum Singleton7Enum{
        INSTANCE;
        private final Singleton7 instance;

        Singleton7Enum() {
            instance = new Singleton7();
        }
        public Singleton7 getInstance(){
            return instance;
        }
    }
    public static Singleton7 getInstance(){
        return Singleton7Enum.INSTANCE.getInstance();
    }
}
