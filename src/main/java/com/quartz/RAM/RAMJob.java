package com.quartz.RAM;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @description
 * @author: gaobh
 * @date: 2018/3/27 10:08
 * @version: v1.0
 */
public class RAMJob implements Job {
    private static Logger _log = LoggerFactory.getLogger(RAMJob.class);

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {

        _log.info("Say hello to Quartz" + new Date());
    }
}
