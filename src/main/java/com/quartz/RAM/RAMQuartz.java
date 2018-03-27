package com.quartz.RAM;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @description
 * @author: gaobh
 * @date: 2018/3/27 10:09
 * @version: v1.0
 */
public class RAMQuartz {
    private static Logger _log = LoggerFactory.getLogger(RAMQuartz.class);

    public static void main(String[] args) throws SchedulerException {
        //1.创建Scheduler的工厂
        SchedulerFactory sf = new StdSchedulerFactory();
        //2.从工厂中获取调度器实例
        Scheduler scheduler = sf.getScheduler();

        //3.创建JobDetail
        JobDetail jb = JobBuilder.newJob(RAMJob.class)
                .withDescription("this is a ram job")
                .withIdentity("ramJob", "ramGroup")
                .build();
        //任务运行时间，SimpleSchedle类型触发器有效
        long time = System.currentTimeMillis() + 3 * 1000L;
        Date statTime = new Date(time);

        //4.创建Trigger
        //使用SimpleScheduleBuilder或者CronScheduleBuilder
        Trigger t = TriggerBuilder.newTrigger()
                .withDescription("")
                .withIdentity("ramTrigger", "ramTriggerGroup")
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule())
                .startAt(statTime)
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();
        //5.注册任务和定时器
        scheduler.scheduleJob(jb, t);

        //6.启动 调度器
        scheduler.start();
        _log.error("启动时间：" + new Date());

    }
}

