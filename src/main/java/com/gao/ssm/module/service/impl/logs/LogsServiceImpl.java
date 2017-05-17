package com.gao.ssm.module.service.impl.logs;

import com.gao.ssm.module.mapper.logs.LogsMapper;
import com.gao.ssm.module.pojo.logs.Logs;
import com.gao.ssm.module.pojo.logs.LogsExample;
import com.gao.ssm.module.service.logs.LogsService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by gaobh on 2016/12/22.
 */
@Service
public class LogsServiceImpl implements LogsService{
    @Resource
    private LogsMapper logsMapper;
    @Resource
    ServletContext context;

    public List<Logs> findAll(){return logsMapper.findAll();}

    public int insert(Logs logs){return logsMapper.insert(logs);}

    public Logs getById(String logId){return logsMapper.selectByPrimaryKey(logId);}

    public int deleteByPrimaryKey(String logId){return logsMapper.deleteByPrimaryKey(logId);}
    public List<Logs> selectByExample(LogsExample example){
        return logsMapper.selectByExample(example);
    }
    public int updateByPrimaryKeySelective(Logs logs){
        return logsMapper.updateByPrimaryKeySelective(logs);
    }

    public  int updateByExampleSelective(Logs record, LogsExample example){return logsMapper.updateByExampleSelective(record,example);}
    //处理项目启动时访问次数加载
    public void installLogsCount(){
        List<Map<String,String>> mapList = new ArrayList<>();
        List<Logs> logsList = findAll();
        for (int i=0;i<logsList.size();i++){
            if (logsList.get(i).getCount()>0){
                Map<String,String> map = new HashedMap();
                map.put("logId",logsList.get(i).getLogId());
                map.put("count",String.valueOf(logsList.get(i).getCount()));
                mapList.add(map);
            }
        }
        context.setAttribute("list",mapList);
    }
}
