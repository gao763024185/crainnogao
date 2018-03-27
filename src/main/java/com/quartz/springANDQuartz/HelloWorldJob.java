package com.quartz.springANDQuartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description Spring 整合 Quartz 的  Hello World!
 * @author: gaobh
 * @date: 2018/3/27 10:32
 * @version: v1.0
 */
public class HelloWorldJob implements Job{
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("This is a first spring combine quartz !");
        log.info("Welcome to Spring_Quartz World!"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) );
        log.info("Let's begin ! \n \n");
    }
}
