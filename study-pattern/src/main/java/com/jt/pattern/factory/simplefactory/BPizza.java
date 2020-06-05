package com.jt.pattern.factory.simplefactory;

/**
 * @author: jingteng
 * @date: 2020/5/31 15:18
 */
public class BPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("准备制作 B 披萨");
    }
}
