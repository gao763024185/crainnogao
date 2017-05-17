package com.gao.ssm.module.controller;

import com.gao.ssm.module.service.TimerRunService;
import com.gao.ssm.module.service.logs.LogsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by 高保红 on 2017/5/16.
 */
@Component
public class PlateformStarter {

    @Resource
    private TimerRunService timerRunService;
    @Resource
    private LogsService logsService;
    @PostConstruct
    public void init(){
        logsService.installLogsCount();//启动时载入访问次数
        timerRunService.countTimer();//启动保存访问次数的定时器
    }
}
