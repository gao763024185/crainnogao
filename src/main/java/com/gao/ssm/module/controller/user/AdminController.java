package com.gao.ssm.module.controller.user;

import com.gao.ssm.module.json.JsonResp;
import com.gao.ssm.module.pojo.FileResult;
import com.gao.ssm.module.pojo.logs.Logs;
import com.gao.ssm.module.pojo.user.BaseUser;
import com.gao.ssm.module.service.logs.LogsService;
import com.gao.ssm.module.service.user.UserInfoService;
import com.gao.ssm.module.tools.FileUploadService;
import com.gao.ssm.module.tools.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaobh on 2016/12/16.
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
    @RequestMapping("/")
    public String loginPage(ModelMap model,@CookieValue(value = "uid",required = false) String uid){
        if (uid == null){
            return view_base+"login";
        }
        else{
            String returnurl = "crainnogao_ad";
            int flag = 1 ;
            return crainnogao_ad(model,null,1, flag,returnurl,uid,null);
        }


    }
    @RequestMapping(value = "/loginVal" ,method = RequestMethod.POST)
    @ResponseBody
    public Object loginVal(BaseUser user, @RequestParam(value = "codetext",required = false) String codetext,
                           HttpServletResponse response,HttpServletRequest request){

        HttpSession session = request.getSession();
        String validateCode = session.getAttribute("validateCode").toString();
        if (validateCode==null || validateCode==""){
            return new JsonResp(JsonResp.Result_Fail,null,"验证码信息过期,请重新刷新输入",null);
        }
        if (!(codetext.equalsIgnoreCase(validateCode))){
            return new JsonResp(JsonResp.Result_Fail,null,"验证码输入错误",null);
        }
        BaseUser baseUser = userInfoService.loginValid(user);
        if (baseUser == null){
            return new JsonResp(JsonResp.Result_Fail,null,"用户名或密码输入错误",null);
        }
        Map<String,String> map = new HashMap<String,String>();
        map.put("uid",String.valueOf(baseUser.getUid()));
        map.put("userName",baseUser.getUserName());
        //写入cookie
//        UserAgent userAgent = new UserAgent();
//        userAgent.setUid(String.valueOf(baseUser.getUid()));
//        userAgent.setUserName(baseUser.getUserName());
//        userAgent.setPassword(baseUser.getPassword());
        // Cookie

        Cookie cookieuid = new Cookie("uid",String.valueOf(baseUser.getUid()));
        cookieuid.setMaxAge(24*60*60);
        response.addCookie(cookieuid);

        Cookie cookieuserName = new Cookie("userName",baseUser.getUserName());
        cookieuserName.setMaxAge(24*60*60);
        response.addCookie(cookieuserName);

        Cookie cookiepsw = new Cookie("password",baseUser.getPassword());
        cookiepsw.setMaxAge(24*60*60);
        response.addCookie(cookiepsw);

        return new JsonResp(JsonResp.Result_Success,null,null,map);
    }
    /*后台主界面*/
    @RequestMapping("/crainnogao_ad")
    public String crainnogao_ad(ModelMap model,Logs logs1,@RequestParam(value = "pageNum",required = false) Integer pageNum,
                                @RequestParam(value = "flag",required = false) Integer flag,@RequestParam(value = "returnurl" ,required = false) String returnurl,@CookieValue(value = "uid",required = false) String uid,
                                @RequestParam(value = "item" ,required = false) String item){

        if (uid==null){
            return view_base+"login";
        }
        //编辑dairy
        if (logs1 != null){
            Logs logDairy = logsService.getById(logs1.getLogId());
            model.addAttribute("logDairy",logDairy);
        }
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
        model.addAttribute("item",item);
        model.addAttribute("pageNum",pageNum);
        //筛选
        if (flag!=null && flag ==1){
            return "redirect:" + returnurl;
        }else{
            return view_base+"crainnogao_ad";
        }



    }

    /*用户信息编辑*/
    @RequestMapping("/userEdit")
    public String userEdit(ModelMap modelMap,@RequestParam(value = "id",required = false) Integer id){

        modelMap.addAttribute("id",id);
        BaseUser user = userInfoService.selectByPrimaryKey(id);
        modelMap.addAttribute("user",user);
        return view_base+"userinfoedit";
    }
    /*日志编辑*/
    @RequestMapping("/dairyEdit")
    public String dairyEdit(@RequestParam(value = "id",required = false) Integer id){

        return view_base+"dairyedit";
    }

    /*用户信息提交*/
    @RequestMapping(value = "/userinfoSubmit", method = RequestMethod.POST)
    public String userinfoSubmit(@ModelAttribute BaseUser user,HttpServletRequest request,
                                 @RequestParam(value = "avatarSub",required = false) MultipartFile avatar
                                )throws IOException{
        String cate = "avatar-user";
        FileResult fileResult = null;
        BaseUser baseUser = new BaseUser();
        if (avatar.getOriginalFilename()!=null && avatar.getOriginalFilename()!=""){
            fileResult = FileUploadService.picSubmit(request,cate,avatar,user.getUid());
            baseUser.setUid(user.getUid());
            baseUser.setUserName(user.getUserName());
            baseUser.setAvatar(fileResult.getAvatarUrl());
        }else{
            baseUser.setUid(user.getUid());
            baseUser.setUserName(user.getUserName());
        }
        userInfoService.updateByPrimaryKeySelective(baseUser);
        return null;
    }

}
