package com.gao.ssm.module.service.logs;

import com.gao.ssm.module.pojo.logs.Logs;

import java.util.List;

/**
 * Created by 孙皓 on 2016/12/22.
 */
public interface LogsService {

    int insert(Logs record);
    List<Logs> findAll();
}
