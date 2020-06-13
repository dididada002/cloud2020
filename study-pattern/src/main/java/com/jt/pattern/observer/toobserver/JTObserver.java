package com.jt.pattern.observer.toobserver;

/**
 * @author: jingteng
 * @date: 2020/6/14 1:23
 */
public class JTObserver implements Observer {

    /**
     * 温度、气压、湿度
     */
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println("*******我是用来测试观察者模式的扩展功能的新观察者*******");
        System.out.println("新----今日天气情况，温度：" + temperature);
        System.out.println("新----今日天气情况，气压：" + pressure);
        System.out.println("新----今日天气情况，湿度：" + humidity);
    }

}
