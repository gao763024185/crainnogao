package com.gao.ssm.module.service.impl.logs;

import com.gao.ssm.module.mapper.logs.LogsMapper;
import com.gao.ssm.module.pojo.logs.Logs;
import com.gao.ssm.module.service.logs.LogsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 孙皓 on 2016/12/22.
 */
@Service
public class LogsServiceImpl implements LogsService{
    @Resource
    private LogsMapper logsMapper;
    public List<Logs> findAll(){return logsMapper.findAll();}
}
