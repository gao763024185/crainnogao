package com.gao.ssm.module.mapper.logs;

import com.gao.ssm.module.pojo.logs.Logs;
import com.gao.ssm.module.pojo.logs.LogsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogsMapper {

    int countByExample(LogsExample example);

    int deleteByExample(LogsExample example);

    int deleteByPrimaryKey(String logId);

    int insert(Logs record);

    int insertSelective(Logs record);

    List<Logs> selectByExample(LogsExample example);

    Logs selectByPrimaryKey(String logId);

    int updateByExampleSelective(@Param("record") Logs record, @Param("example") LogsExample example);

    int updateByExample(@Param("record") Logs record, @Param("example") LogsExample example);


    int updateByPrimaryKeySelective(Logs record);

    int updateByPrimaryKey(Logs record);

    List<Logs> findAll();

}