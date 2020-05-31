package com.jt.pattern.factory.simplefactory;

/**
 * @author: jingteng
 * @date: 2020/5/31 15:24
 * 订购客户端
 */
public class OrderPizza {
    PizzaFactory pizzaFactory;
    Pizza pizza = null;

    public OrderPizza(PizzaFactory pizzaFactory,String orderType) {
        this.pizzaFactory = pizzaFactory;
        pizza = pizzaFactory.createPizza(orderType);
        if (pizza != null) {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
    }
}
