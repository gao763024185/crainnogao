package com.gao.ssm.module.service.impl;

import com.gao.ssm.module.pojo.logs.Logs;
import com.gao.ssm.module.pojo.logs.LogsExample;
import com.gao.ssm.module.service.TimerRunService;
import com.gao.ssm.module.service.logs.LogsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;

/**
 * @description 定时器service
 * @author: gaobh
 * @date: 2017/5/17
 * @version: v1.0
 */
@Service
public class TimerRunServiceImpl implements TimerRunService {
    @Resource
    ServletContext context;
    @Resource
    private LogsService logsService;

    @Override
    public void countTimer() {
        /**
         * 10分钟执行一次
         */
        final long timeInterval = 10 * 60 * 1000;

        new Thread() {
            public void run() {
                while (true) {
                    count();
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void count() {
        List<Map<String, String>> mapList = (List) context.getAttribute("list");
        if (mapList != null && mapList.size() > 0) {
            for (Map<String, String> map : mapList) {
                LogsExample logsExample = new LogsExample();
                LogsExample.Criteria criteria = logsExample.createCriteria();
                criteria.andLogIdEqualTo(map.get("logId"));
                Logs logs = new Logs();
                logs.setCount(Integer.valueOf(map.get("count")));
                logsService.updateByExampleSelective(logs, logsExample);
            }
        }
    }
}
