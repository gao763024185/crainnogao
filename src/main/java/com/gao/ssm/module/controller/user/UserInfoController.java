package com.gao.ssm.module.controller.user;

import com.gao.ssm.module.service.user.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by 孙皓 on 2016/12/13.
 */
@Controller
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @RequestMapping("/crainnogao")
    public String showTest(){
        return "crainnogao";
    }
}
