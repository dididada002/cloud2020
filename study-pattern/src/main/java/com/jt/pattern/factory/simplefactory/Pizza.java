package com.jt.pattern.factory.simplefactory;

/**
 * @author: jingteng
 * @date: 2020/5/31 15:15
 */
public abstract class Pizza {
    String name;

    public abstract void prepare();

    public void  bake(){
        System.out.println(name + "开始烘烤");
    }

    public void cut(){
        System.out.println(name + "开始切割");
    }

    public void  box(){
        System.out.println(name + "开始包装");
    }

    public void setName(String name){
        this.name = name;
    }

}
