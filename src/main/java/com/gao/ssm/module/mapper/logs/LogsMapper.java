package com.gao.ssm.module.mapper.logs;

import com.gao.ssm.module.pojo.logs.Logs;

import java.util.List;

public interface LogsMapper {

    int deleteByPrimaryKey(String logId);

    int insert(Logs record);

    int insertSelective(Logs record);

    Logs selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(Logs record);

    int updateByPrimaryKey(Logs record);

    List<Logs> findAll();

    /**
     * 定义分页功能
     * @param logs
     * @param pageNum
     * @param pageSize
     * @return
     */

//    public Pager<Logs> findAll(List<Logs> logs,int pageNum,int pageSize);
}