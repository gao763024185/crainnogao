package com.gao.ssm.module.user.controller;

import com.gao.ssm.module.user.json.JsonResp;
import com.gao.ssm.module.user.pojo.BaseUser;
import com.gao.ssm.module.user.service.UserInfoService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    public Object login(BaseUser user, @RequestParam(value = "codetext",required = false) String codetext,
                        HttpServletRequest request){

        HttpSession session = request.getSession();
        String validateCode = session.getAttribute("validateCode").toString();
        if (!codetext.equalsIgnoreCase(validateCode)){
            return new JsonResp(JsonResp.Result_Fail,null,"验证码输入错误",null);
        }
        BaseUser baseUser = userInfoService.loginValid(user);
        return new JsonResp(JsonResp.Result_Success,null,null,null);
    }
}
