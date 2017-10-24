package com.test.observerpattern;

/**
 * Created by 高保红 on 2017/9/25.
 */
public class ObserverBean {

    private String netType;

    private String netStatus;

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public String getNetStatus() {
        return netStatus;
    }

    public void setNetStatus(String netStatus) {
        this.netStatus = netStatus;
    }

    public ObserverBean(String netType, String netStatus) {
        this.netType = netType;
        this.netStatus = netStatus;
    }
}
