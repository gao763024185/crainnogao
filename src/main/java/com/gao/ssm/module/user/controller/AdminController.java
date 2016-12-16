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
 * Created by 孙皓 on 2016/12/16.
 */
@Controller
@RequestMapping("/crainnogao/admin")
public class AdminController {
    @Resource
    private UserInfoService userInfoService;
    String view_base="/admin/";

    /*后台首页*/
    @RequestMapping("/login")
    public String loginPage(){
        return view_base+"login";
    }
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    @ResponseBody
    public Object login(BaseUser user){
        BaseUser baseUser = userInfoService.loginValid(user);
        return new JsonResp(JsonResp.Result_Success,null,null,null);
    }
}
