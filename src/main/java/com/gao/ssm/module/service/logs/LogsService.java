package com.gao.ssm.module.service.logs;

import com.gao.ssm.module.pojo.logs.Logs;

import java.util.List;

/**
 * Created by gaobh on 2016/12/22.
 */
public interface LogsService {

    Logs getById(String logId);
    int insert(Logs record);
    List<Logs> findAll();

//     Pager<Logs> findAll (List<Logs> logs,int pageNum,int pageSize);
    int deleteByPrimaryKey(String logId);
}
