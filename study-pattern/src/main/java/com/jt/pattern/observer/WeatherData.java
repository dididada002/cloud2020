package com.jt.pattern.observer;

/**
 * @author: jingteng
 * @date: 2020/6/13 23:27
 */
public class WeatherData {

    private float temperature;
    private float pressure;
    private float humidity;
    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
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
        currentConditions.update(getTemperature(),getPressure(),getHumidity());
    }

    public void setData(float temperature,float pressure,float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }
}
