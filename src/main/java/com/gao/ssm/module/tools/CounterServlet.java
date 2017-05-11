package com.gao.ssm.module.tools;

/**
 * Created by 高保红 on 2017/5/2.
 */

import org.apache.commons.collections.map.HashedMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
public class CounterServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //一个web应用程序只有一个上下文对象,该上下文对象可访问所有servlet
        ServletContext context = getServletContext();
        synchronized (context) {

            List<Map<String,String>> list = new ArrayList<>();

            String logId = context.getAttribute("logId").toString(); //当前传进来的logId
            list = (List) context.getAttribute("list");
            Set<String> set = new HashSet<>();
            for (int i=0;i<list.size();i++){
                set.add(list.get(i).get("logId"));
            }
            //若是没有logId就添加
            if (!set.contains(logId)) {   //不包含为false
                Map<String,String> map = new HashedMap();
                map.put("logId",logId);
                map.put("count","1");
                list.add(map);
            }
            for (Map<String, String> map1 : list){
                Integer count = 1;
                if (logId.equals(map1.get("logId"))){
                    count = Integer.valueOf(map1.get("count"));
                    if (null == count) {
                        count = new Integer(1);
                    } else {
                        count = new Integer(count.intValue() + 1);
                    }
                    map1.put("count",String.valueOf(count));
                }
            }
            context.setAttribute("list", list);
        }
    }
}
