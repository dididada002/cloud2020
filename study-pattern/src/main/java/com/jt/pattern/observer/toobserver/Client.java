package com.jt.pattern.observer.toobserver;

/**
 * @author: jingteng
 * @date: 2020/6/14 1:17
 */
public class Client {
    public static void main(String[] args) {
        //1-创建一个服务提供方
        WeatherData weatherData = new WeatherData();

        //1-创建一个观察者
        CurrentConditions currentConditions = new CurrentConditions();

        //1-注册到服务提供方
        weatherData.registerObserver(currentConditions);

        System.out.println("***************通知全部注册的观察者*****************");
        weatherData.setData(10,100,12312);

    }
}
