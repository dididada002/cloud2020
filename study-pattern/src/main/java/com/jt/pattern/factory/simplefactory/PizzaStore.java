package com.jt.pattern.factory.simplefactory;

/**
 * @author: jingteng
 * @date: 2020/5/31 15:31
 */
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new PizzaFactory(),"A");
        System.out.println("退出程序");
    }
}
