package com.gao.ssm.module.service.logs;

import com.gao.ssm.module.pojo.logs.Logs;
import com.gao.ssm.module.pojo.logs.LogsExample;

import java.util.List;

/**
 * Created by gaobh on 2016/12/22.
 */
public interface LogsService {

    Logs getById(String logId);
    int insert(Logs record);
    List<Logs> findAll();

    int deleteByPrimaryKey(String logId);

    List<Logs> selectByExample(LogsExample example);

    int updateByPrimaryKeySelective(Logs logs);

    void installLogsCount();

    int updateByExampleSelective(Logs record, LogsExample example);
}
