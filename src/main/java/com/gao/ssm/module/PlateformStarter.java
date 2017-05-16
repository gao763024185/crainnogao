package com.gao.ssm.module;

import com.gao.ssm.module.service.TimerRunService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by 高保红 on 2017/5/16.
 */

public class PlateformStarter {
    @Resource
    private TimerRunService timerRunService;

    @PostConstruct
    public void init(){
        System.out.println("啦啦啦");
        timerRunService.sys();
    }
}
