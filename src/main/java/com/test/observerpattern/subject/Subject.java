package com.test.observerpattern.subject;


import com.test.observerpattern.observer.Observer;

/**
 * Created by 高保红 on 2017/9/25.
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}
