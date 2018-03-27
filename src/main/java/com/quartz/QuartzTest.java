package com.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @description quartz测试类
 * Quartz：任务调度框架
 * @author: gaobh
 * @date: 2018/3/21 15:54
 * @version: v1.0
 */
public class QuartzTest {
    /**
     * quartz 任务调度说明：
     *      Scheduler：调度器。所有的调度都是由他控制。
     *      Trigger：定义触发的条件。
     *      JobDetail&Job：JobDetail定义的是任务数据，而真正的执行逻辑是在Job中。设计成JobDetail+Job，不直接使用Job，是因为任务
     *                    是有可能并发执行的，如果Scheduler直接使用Job，就会存在对同一个Job实例并发执行，如果Scheduler直接使用
     *                    Job，就会存在对同一个Job实例并发访问的问题。而JobDetail&Job方式，sheduler每次执行，就会根据JobDetail
     *                    创建一个新的Job实例，这样就可以规避并发访问的问题。
     * @param args
     */
    public static void main(String[] args) {
        try {
            //创建scheduler：调度器。所有的调度都是由他控制
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            //定义一个Trigger 触发的条件
            Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
                    //一旦加入scheduler，立即生效
                    .startNow()
                    //使用SimpleTrigger
                    .withSchedule(simpleSchedule()
                            //每隔一秒执行一次
                            .withIntervalInSeconds(1)
                            //一直执行，奔腾到老不停歇
                            .repeatForever())
                    .build();

            //定义一个JobDetail
            //定义Job类为HelloQuartz类，这是真正的执行逻辑所在
            JobDetail job = newJob(HelloQuartz.class)
                    //定义name/group
                    .withIdentity("job1", "group1")
                    //定义属性
                    .usingJobData("name", "quartz")
                    .build();

            //加入这个调度
            scheduler.scheduleJob(job, trigger);

            //启动之
            scheduler.start();

            //运行一段时间后关闭
            Thread.sleep(10000);
            scheduler.shutdown(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
