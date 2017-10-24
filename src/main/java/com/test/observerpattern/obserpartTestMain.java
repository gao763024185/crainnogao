package com.test.observerpattern;

import com.test.observerpattern.observer.ConcreteObserverA;
import com.test.observerpattern.observer.ConcreteObserverB;
import com.test.observerpattern.subject.NetConcreteSubject;

/**
 * Created by 高保红 on 2017/9/25.
 */
public class obserpartTestMain {
    public static void main(String[] args) {

        //初始化主题(被观察者)
        NetConcreteSubject subject = new NetConcreteSubject();
        //初始化观察者A
        ConcreteObserverA observerA = new ConcreteObserverA();
        //初始化观察者B
        ConcreteObserverB observerB = new ConcreteObserverB();
        //注册观察者A
        subject.registerObserver(observerA);
        //注册观察者B
        subject.registerObserver(observerB);
        subject.removeObserver(observerB);
        //通知所有观察者数据有更新
        ObserverBean bean = new ObserverBean("wifi", "有网");
        subject.setStatusChanged(bean);
    }
}
