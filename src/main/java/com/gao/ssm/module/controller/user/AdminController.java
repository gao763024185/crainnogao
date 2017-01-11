package com.gao.ssm.module.controller.user;

import com.gao.ssm.module.json.JsonResp;
import com.gao.ssm.module.pojo.logs.Logs;
import com.gao.ssm.module.pojo.user.BaseUser;
import com.gao.ssm.module.service.logs.LogsService;
import com.gao.ssm.module.service.user.UserInfoService;
import com.gao.ssm.module.tools.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 孙皓 on 2016/12/16.
 */
@Controller
@RequestMapping("/crainnogao/admin")
public class AdminController {
    @Resource
    private UserInfoService userInfoService;

    @Resource
    private LogsService logsService;
    String view_base="/admin/";

    /*后台登录页*/
    @RequestMapping("/login")
    public String loginPage(){
        return view_base+"login";
    }
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    @ResponseBody
    public Object login(BaseUser user, @RequestParam(value = "codetext",required = false) String codetext,HttpServletRequest request){

        HttpSession session = request.getSession();
        String validateCode = session.getAttribute("validateCode").toString();
        if (!(codetext.equalsIgnoreCase(validateCode))){
            return new JsonResp(JsonResp.Result_Fail,null,"验证码输入错误",null);
        }
        BaseUser baseUser = userInfoService.loginValid(user);
        return new JsonResp(JsonResp.Result_Success,null,null,null);
    }

    @RequestMapping("/crainnogao_ad")
    public String crainnogao_ad(ModelMap model,@RequestParam(value = "pageNum",required = false) Integer pageNum){

        if (pageNum == null){
            pageNum = 1;
        }
        int pageSize = 10;
        //用户信息显示
        List<BaseUser> user = userInfoService.findAll();
        model.addAttribute("list",user);
        //logs信息显示
        List<Logs> logs = logsService.findAll();
        Pager<Logs> logsPager = new Pager<Logs>(pageNum,pageSize,logs);
        model.addAttribute("listlogs",logsPager);
        return view_base+"crainnogao_ad";
    }
}
