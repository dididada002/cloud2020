package com.jt.pattern.factory.simplefactory;

/**
 * @author: jingteng
 * @date: 2020/5/31 15:20
 */
public class PizzaFactory {

    public Pizza createPizza(String orderType){
        Pizza pizza = null;
        System.out.println("使用简单工厂模式生产披萨");
        if ("A".equals(orderType)){
            pizza = new APizza();
            pizza.setName("A 披萨");
        }else if ("B".equals(orderType)){
            pizza = new BPizza();
            pizza.setName("B 披萨");
        }


        return pizza;
    }
}
