package com.gao.ssm.module.controller.user;

import com.gao.ssm.module.pojo.logs.Logs;
import com.gao.ssm.module.pojo.logs.LogsExample;
import com.gao.ssm.module.service.logs.LogsService;
import com.gao.ssm.module.service.user.UserInfoService;
import com.gao.ssm.module.tools.Pager;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by gaobh on 2016/12/13.
 */
@Controller
@RequestMapping("/crainnogao")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private LogsService logsService;

    private String view_base = "/p/";
    @RequestMapping("/")
    public String showTest(ModelMap modelMap,@RequestParam(value = "pageNum",required = false) Integer pageNum){
        if (pageNum == null){
            pageNum=1;
        }
        int pageSize=5;
        List<Logs> logsList = logsService.findAll();
        //最新笔记
        Pager<Logs> pager = new Pager<Logs>(pageNum,8,logsList);
        modelMap.addAttribute("logs",pager);
        modelMap.addAttribute("logsCount",pager.getDataList().size());
        //分页显示的笔记
        Pager<Logs> pager1 = new Pager<Logs>(pageNum,pageSize,logsList);
        modelMap.addAttribute("logs1",pager1);
        modelMap.addAttribute("pageNum",pageNum);
        return "crainnogao";
    }

    @RequestMapping("fenye")
    @ResponseBody
    public Object fenye(@RequestParam(value = "pageNum",required = false) Integer pageNum,
                        @RequestParam(value = "item",required = false) String item,
        @RequestParam(value = "pageSize",required = false) Integer pageSize,Logs logs){

        if(pageNum==null){
            pageNum=1;
        }
        pageSize=10;
        List<Logs> logsList = null;
        if (logs!=null){
            LogsExample logsExample = new LogsExample();
            logsExample.or().andLogTitleLike("%"+logs.getLogTitle()+"%");
            logsList = logsService.selectByExample(logsExample);
        }else {
            logsList = logsService.findAll();
        }

        for (Logs logs1:logsList){
            logs1.setLogCreatedStr(logs1.getLogCreated(),"yyyy-MM-dd HH:mm");
            logs1.setLogUpdateStr(logs1.getLogUpdate(),"yyyy-MM-dd HH:mm");
        }
        Pager<Logs> logs2 = new Pager<Logs>(pageNum,pageSize,logsList);
        System.out.println(logs2.getDataList().get(0).getLogCreatedStr());
        Map<String,Object> map = new HashedMap();
        map.put("logs2",logs2.getDataList());
        map.put("toPage",logs2.getTotalPage());
        map.put("len",logs2.getDataList().size());
        return map;
    }
    @RequestMapping("/logshow")
    @ResponseBody
    public Object logshow(ModelMap modelMap,@RequestParam(value = "logId") String logId){
        Logs logs = logsService.getById(logId);
        logs.setLogCreatedStr(logs.getLogCreated(),"yyyy-MM-dd HH:mm");
        logs.setLogUpdateStr(logs.getLogUpdate(),"yyyy-MM-dd HH:mm");
        return logs;
    }

    @RequestMapping("/detail")
    public String detail(ModelMap modelMap,@RequestParam(value = "logId") String logId){
        Logs logs = logsService.getById(logId);
        modelMap.addAttribute("logs",logs);
        return "detail";
    }
//    进入about页面
    @RequestMapping("/about")
    public String about(){
        return "about";
    }

//    进入归档页面
    @RequestMapping("/documents")
    public String documents(ModelMap modelMap){
        List<Logs> logsList = logsService.findAll();
        modelMap.addAttribute("logsList",logsList);
        return "documents";
    }

}
