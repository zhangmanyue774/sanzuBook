package com.sanzu.sanzuBook.controller.Login;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sanzu.sanzuBook.common.request;
import com.sanzu.sanzuBook.service.UserService;
import com.sanzu.sanzuBook.service.impl.UserServicelmpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/retrieve")
public class retrieve extends getCode{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject json = JSONObject.parseObject(request.requestBody(req,resp));
        resp.setContentType("application/json;charset=UTF-8");
        // 解析请求体参数
        String userEmail = json.getString("email");
        String code = json.getString("code");
        String password = json.getString("password");
        if(super.Authentication(userEmail,code)){
            super.setMap(userEmail);
            UserService userService = new UserServicelmpl();
            if(userService.getSelectAccount(userEmail)==null){
                resp.getWriter().write(JSON.toJSONString("用户信息不存在"));
            }
            else {
                Integer re = userService.getUpdatePassword(userEmail, password);
                if (re == 1) {
                    resp.getWriter().write(JSON.toJSONString("重置密码成功"));
                    userService.getUpdateOperation(userService.getSelectAccount(userEmail).getId(),"找回密码:"+java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+"\n"+"请求IP:"+request.getIPv4(req));
                } else resp.getWriter().write("重置失败");
            }
        }
        else resp.getWriter().write(JSON.toJSONString("验证码错误,请重新输入"));
    }
}
