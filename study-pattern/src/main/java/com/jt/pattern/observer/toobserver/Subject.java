package com.jt.pattern.observer.toobserver;

/**
 * @author: jingteng
 * @date: 2020/6/14 1:07
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
