package com.quartz.springANDQuartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: gaobh
 * @date: 2018/3/27 10:34
 * @version: v1.0
 */
public class HWTest {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring_quartz.xml");

    }
}
