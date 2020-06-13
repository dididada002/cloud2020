package com.jt.pattern.observer;

/**
 * @author: jingteng
 * @date: 2020/6/13 23:08
 * 显示当前天气情况
 */
public class CurrentConditions {
    /**
     * 温度、气压、湿度
     */
    private float temperature;
    private float pressure;
    private float humidity;

    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println("今日天气情况，温度：" + temperature);
        System.out.println("今日天气情况，气压：" + pressure);
        System.out.println("今日天气情况，湿度：" + humidity);
    }


}
