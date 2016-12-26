package com.gao.ssm.module.controller.user;

import com.gao.ssm.module.pojo.logs.Logs;
import com.gao.ssm.module.service.logs.LogsService;
import com.gao.ssm.module.service.user.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 孙皓 on 2016/12/13.
 */
@Controller
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private LogsService logsService;

    @RequestMapping("/crainnogao")
    public String showTest(ModelMap modelMap){
        List<Logs> logs = logsService.findAll();
        modelMap.addAttribute("logs",logs);
        return "crainnogao";
    }
}
