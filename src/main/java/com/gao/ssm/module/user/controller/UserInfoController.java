package com.gao.ssm.module.user.controller;

import com.gao.ssm.module.user.json.JsonResp;
import com.gao.ssm.module.user.pojo.BaseUser;
import com.gao.ssm.module.user.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
