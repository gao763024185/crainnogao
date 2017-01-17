package com.gao.ssm.module.service.impl.logs;

import com.gao.ssm.module.mapper.logs.LogsMapper;
import com.gao.ssm.module.pojo.logs.Logs;
import com.gao.ssm.module.service.logs.LogsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaobh on 2016/12/22.
 */
@Service
public class LogsServiceImpl implements LogsService{
    @Resource
    private LogsMapper logsMapper;

    public List<Logs> findAll(){return logsMapper.findAll();}

    public int insert(Logs logs){return logsMapper.insert(logs);}

    public Logs getById(String logId){return logsMapper.selectByPrimaryKey(logId);}

    public int deleteByPrimaryKey(String logId){return logsMapper.deleteByPrimaryKey(logId);}
//    public Pager<Logs> findAll (List<Logs> logs, int pageNum, int pageSize){
//        return logsMapper.findAll(logs,pageNum,pageSize);
//    }
}
