package com.jt.pattern.observer.toobserver;

/**
 * @author: jingteng
 * @date: 2020/6/14 1:08
 * 观察者接口，由观察者来实现
 */
public interface Observer {
    public void update(float temperature, float pressure, float humidity);
}
