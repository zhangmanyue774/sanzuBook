package com.sanzu.sanzuBook.controller.Console;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sanzu.sanzuBook.common.JwtUtil;
import com.sanzu.sanzuBook.common.request;
import com.sanzu.sanzuBook.entity.ReportEntity;
import com.sanzu.sanzuBook.service.ReportService;
import com.sanzu.sanzuBook.service.UserService;
import com.sanzu.sanzuBook.service.impl.ReportServiceImpl;
import com.sanzu.sanzuBook.service.impl.UserServicelmpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/login/insertReport")
public class insertReport extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject json = JSONObject.parseObject(request.requestBody(req,resp));
        ReportService reportService = new ReportServiceImpl();
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setWhistleblower(json.getString("email1"));
        reportEntity.setReportedPerson(json.getString("email2"));
        reportEntity.setContext(json.getString("context"));
        reportEntity.setReason(json.getString("reason"));
        resp.setContentType("application/json;charset=UTF-8");
        try {
            Integer re = reportService.getInsertNewReport(reportEntity);
            if(re==1){
                resp.getWriter().write(JSON.toJSONString("举报成功"));
                UserService userService = new UserServicelmpl();
                userService.getUpdateOperation(userService.getSelectAccount(json.getString("email1")).getId(),
                        "发起举报:"+
                                (java.time.LocalDateTime.now().
                                        format(java.time.format.DateTimeFormatter.
                                                ofPattern("yyyy-MM-dd HH:mm:ss"))+"\n"+
                                        "操作IP:"+ request.getIPv4(req)));
            }
        }catch (Exception e){
            resp.getWriter().write(JSON.toJSONString("不能频繁举报单个用户"));
        }
    }
}
