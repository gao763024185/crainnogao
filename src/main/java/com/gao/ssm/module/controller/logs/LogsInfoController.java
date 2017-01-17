package com.gao.ssm.module.controller.logs;

import com.gao.ssm.module.json.JsonResp;
import com.gao.ssm.module.pojo.logs.Logs;
import com.gao.ssm.module.service.logs.LogsService;
import com.gao.ssm.module.tools.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by gaobh on 2016/12/22.
 */
@Controller
public class LogsInfoController {

    @Resource
    private LogsService logsService;
    String view_base="/admin/";
    //日志提交
    @RequestMapping(value = "/issue")
    @ResponseBody
    public Object issue(@RequestParam(value = "codetext",required = false) String codetext, HttpServletRequest request,
                        Logs logs){
        HttpSession session = request.getSession();
        String validateCode = session.getAttribute("validateCode").toString();
        if (!(codetext.equalsIgnoreCase(validateCode))){
            return new JsonResp(JsonResp.Result_Fail,null,"验证码输入错误",null);
        }
        logs.setLogId(DateUtil.format(new Date(),"yyMMddHHmmss"));
        logs.setLogCreated(new Date());
        logs.setLogUpdate(new Date());
        logsService.insert(logs);
        return new JsonResp(JsonResp.Result_Success,null,null,null);
    }
    /*删除日志*/
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(@RequestParam(value = "logId",required = false) String logId){
        logsService.deleteByPrimaryKey(logId);
        return new JsonResp(JsonResp.Result_Success,null,null,null);
    }
    /*更新日志*/
//    @RequestMapping("/edit")
//    @ResponseBody
//    public Object edit(@RequestParam(value = "logId",required = false) String logId){
//        logsService.deleteByPrimaryKey(logId);
//        return new JsonResp(JsonResp.Result_Success,null,null,null);
//    }
}
