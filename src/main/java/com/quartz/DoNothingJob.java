package com.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @description
 * @author: gaobh
 * @date: 2018/3/27 9:55
 * @version: v1.0
 */
public class DoNothingJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("do nothing");
    }
}
