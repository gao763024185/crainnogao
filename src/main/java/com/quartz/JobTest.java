package com.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @description JobDetail是任务的定义，而Job是任务的执行逻辑。在JobDetail里会引用一个Job Class定义
 * @author: gaobh
 * @date: 2018/3/27 9:54
 * @version: v1.0
 */
public class JobTest {
    public static void main(String[] args) throws SchedulerException, IOException {
        JobDetail job = newJob()
                //引用Job Class
                .ofType(DoNothingJob.class)
                //设置name/group
                .withIdentity("job1", "group1")
                //设置描述
                .withDescription("this is a test job")
                //加入属性到ageJobDataMap
                .usingJobData("age", 18)
                .build();

        //加入属性name到JobDataMap
        job.getJobDataMap().put("name", "quertz");

        //定义一个每秒执行一次的SimpleTrigger
        Trigger trigger = newTrigger()
                .startNow()
                .withIdentity("trigger1")
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();

        Scheduler sche = StdSchedulerFactory.getDefaultScheduler();
        sche.scheduleJob(job, trigger);

        sche.start();

        System.in.read();

        sche.shutdown();
    }
}
