package com.gao.ssm.module.controller.user;

import com.gao.ssm.module.pojo.logs.Logs;
import com.gao.ssm.module.service.logs.LogsService;
import com.gao.ssm.module.service.user.UserInfoService;
import com.gao.ssm.module.tools.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
        int pageSize=10;
        List<Logs> logsList = logsService.findAll();
        Pager<Logs> pager = new Pager<Logs>(pageNum,pageSize,logsList);
        modelMap.addAttribute("logs",pager);
        modelMap.addAttribute("logsCount",pager.getDataList().size());
        return "crainnogao";
    }

    @RequestMapping("fenye")
    @ResponseBody
    public Object fenye(@RequestParam(value = "pageNum",required = false) Integer pageNum,
        @RequestParam(value = "pageSize",required = false) Integer pageSize){

        pageSize=10;
        List<Logs> logsList = logsService.findAll();
        for (Logs logs:logsList){
            logs.setLogCreatedStr(logs.getLogCreated(),"yyyy-MM-dd HH:mm");
            logs.setLogUpdateStr(logs.getLogUpdate(),"yyyy-MM-dd HH:mm");
        }
        Pager<Logs> logs = new Pager<Logs>(pageNum,pageSize,logsList);
        System.out.println(logs.getDataList().get(0).getLogCreatedStr());
        return logs.getDataList();
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
    @RequestMapping("/about")
    public String about(){
        return "about";
    }

}
