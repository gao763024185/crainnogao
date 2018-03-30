package com.quartz.springANDQuartz;

import org.springframework.stereotype.Component;

/**
 * @description myjob
 * @author: gaobh
 * @date: 2018/3/30 10:50
 * @version: v1.0
 */
@Component("myJob")
public class MyJob {
    public void myMethod(){
        System.out.println("3456789987");
    }
}
