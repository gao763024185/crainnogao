package com.test.observerpattern.observer;

import com.test.observerpattern.ObserverBean;

/**
 * Created by 高保红 on 2017/9/25.
 */
public class ConcreteObserverA implements Observer {

    @Override
    public void update(Object obj) {
        if (obj instanceof ObserverBean) {
            ObserverBean bean = (ObserverBean) obj;
            System.out.print("ConcreteObserverA 网络类型："
                    + bean.getNetType() + ",网络状态：" + bean.getNetStatus() + "\n");
        }
    }
}