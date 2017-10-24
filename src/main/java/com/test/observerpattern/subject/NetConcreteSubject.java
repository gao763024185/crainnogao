package com.test.observerpattern.subject;

import com.test.observerpattern.ObserverBean;
import com.test.observerpattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 高保红 on 2017/9/25.
 */
public class NetConcreteSubject implements Subject {

    private List<Observer> observers;
    private ObserverBean bean;

    public NetConcreteSubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int pos = observers.indexOf(observer);
        if (pos > 0) {
            observers.remove(pos);
        }
    }


    @Override
    public void notifyObservers() {
        if (bean == null) return;
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = observers.get(i);
            observer.update(bean);
        }

    }

    public void setStatusChanged(ObserverBean bean) {
        this.bean = bean;
        notifyObservers();
    }
}