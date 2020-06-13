package com.jt.pattern.observer;

/**
 * @author: jingteng
 * @date: 2020/6/13 23:37
 */
public class Client {
    public static void main(String[] args) {
        //创建接入方
        CurrentConditions currentConditions = new CurrentConditions();

        //创建weatherData
        WeatherData weatherData = new WeatherData(currentConditions);

        //更新天气情况
        weatherData.setData(30,10,22);
    }
}
