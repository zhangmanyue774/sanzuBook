package com.sanzu.sanzuBook.controller.Console;

import com.alibaba.fastjson.JSON;
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

@WebServlet("/console/dealWith")
public class dealWithReport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rid = Integer.parseInt(req.getParameter("id"));
        int day = Integer.parseInt(req.getParameter("day"));
        String email = req.getParameter("email");
        UserService userService = new UserServicelmpl();
        Integer id = userService.getSelectAccount(email).getId();
        Integer re = userService.updateBan(id,day);
        resp.setContentType("application/json;charset=UTF-8");
        ReportService reportService = new ReportServiceImpl();
        reportService.getUpdateIsDeal(rid);
        if(re==1){
            resp.getWriter().write(JSON.toJSONString("处理成功!"+"封禁"+day+"天"));
        }
    }
}
