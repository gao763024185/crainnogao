package com.gao.ssm.module.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 孙皓 on 2016/12/13.
 */
@Controller
@RequestMapping("/gaobh/blog")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping("/show")
    public String showTest(){
        return "gaobh";
    }

    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    @ResponseBody
    public Object login(BaseUser user){
        BaseUser baseUser = userInfoService.loginValid(user);
//        System.out.println(JSONUtils.toJSONString(baseUser));
        return new JsonResp(JsonResp.Result_Success,null,null,null);
//        return JSONUtils.toJSONString(baseUser);
    }

}
