package com.jt.pattern.observer.toobserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jingteng
 * @date: 2020/6/13 23:27
 */
public class WeatherData implements Subject{

    private float temperature;
    private float pressure;
    private float humidity;
    //观察者集合
    private List<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    //将最新的信息推送给接入方
    public void dataChange(){
        notifyObserver();
    }

    public void setData(float temperature,float pressure,float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this.temperature,this.pressure,this.humidity);
        }

    }
}
