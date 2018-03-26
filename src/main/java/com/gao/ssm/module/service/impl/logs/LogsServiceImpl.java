package com.gao.ssm.module.service.impl.logs;

import com.gao.ssm.module.mapper.logs.LogsMapper;
import com.gao.ssm.module.pojo.logs.Logs;
import com.gao.ssm.module.pojo.logs.LogsExample;
import com.gao.ssm.module.service.logs.LogsService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description 日志service
 * @author: gaobh
 * @date: 2016/12/22
 * @version: v1.0
 */
@Service
public class LogsServiceImpl implements LogsService {
    @Resource
    private LogsMapper logsMapper;
    @Resource
    ServletContext context;

    @Override
    public List<Logs> findAll() {
        return logsMapper.findAll();
    }

    @Override
    public int insert(Logs logs) {
        return logsMapper.insertSelective(logs);
    }

    @Override
    public Logs getById(String logId) {
        return logsMapper.selectByPrimaryKey(logId);
    }

    @Override
    public int deleteByPrimaryKey(String logId) {
        return logsMapper.deleteByPrimaryKey(logId);
    }

    @Override
    public List<Logs> selectByExample(LogsExample example) {
        return logsMapper.selectByExample(example);
    }

    @Override
    public int updateByPrimaryKeySelective(Logs logs) {
        return logsMapper.updateByPrimaryKeySelective(logs);
    }

    @Override
    public int updateByExampleSelective(Logs record, LogsExample example) {
        return logsMapper.updateByExampleSelective(record, example);
    }

    private final static Logger logger = LoggerFactory.getLogger(LogsServiceImpl.class);
    /**
     * 处理项目启动时访问次数加载
     */
    @Override
    public void installLogsCount() {
        List<Map<String, String>> mapList = new ArrayList<>();
        List<Logs> logsList = findAll();
        logger.error("-------installLogsCount-------"+logsList.size());
        if (CollectionUtils.isNotEmpty(logsList)){
            for (int i = 0; i < logsList.size(); i++) {
                if (null != logsList.get(i)){
                    logger.error("-------logsList.get(i)-------"+logsList.get(i));
                    if (logsList.get(i).getCount() > 0) {
                        Map<String, String> map = new HashedMap();
                        map.put("logId", logsList.get(i).getLogId());
                        map.put("count", String.valueOf(logsList.get(i).getCount()));
                        mapList.add(map);
                    }
                }
            }
        }
        context.setAttribute("list", mapList);
    }
}
