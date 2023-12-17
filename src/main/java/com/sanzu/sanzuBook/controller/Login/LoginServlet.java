package com.sanzu.sanzuBook.controller.Login;

import com.alibaba.fastjson.JSON;
import com.sanzu.sanzuBook.common.JwtUtil;
import com.sanzu.sanzuBook.common.request;
import com.sanzu.sanzuBook.entity.UserEntity;
import com.sanzu.sanzuBook.service.UserService;
import com.sanzu.sanzuBook.service.impl.UserServicelmpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServicelmpl();
        String account = req.getParameter("email");
        String password = req.getParameter("password");
        UserEntity user = userService.getUserCredentials(account, password);
        Map<String, Object> map = new HashMap<>();
        boolean isTime = false;
        if (user != null) {
            //判断是否被封
            System.out.println(user.getBan_duration());
            if (user.getBan_duration() != 0) {
                System.out.println("被封了");
                String banDuration = user.getUnban_date();
                // 获取当前时间
                Date currentTime = new Date();
                // 将获取到的时间字符串转换为日期对象
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date banEndTime = null;
                try {
                    banEndTime = dateFormat.parse(banDuration);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                // 判断是否解封
                if (currentTime.after(banEndTime)) {
                    userService.updateBan(user.getId(), 0);
                } else {
                    isTime = true;
                    map.put("success", false);
                    map.put("message", "您的账号已被封禁，解封时间:" + user.getUnban_date());
                }
            }
            if (!isTime) {
                String username = user.getUsername();
                String avatar = user.getAvatar();
                Integer userID = user.getId();
                boolean isAdmin = user.getAdmin();
                String token = JwtUtil.generateToken(account, username, avatar, userID, isAdmin);
                Cookie cookie = new Cookie("token", token);
                cookie.setPath("/");
                cookie.setMaxAge(60 * 60);
                if (isAdmin) {
                    String admin_token = JwtUtil.generateToken(account, username, avatar, userID, true);
                    Cookie adminCookie = new Cookie("admin_token", admin_token);
                    adminCookie.setPath("/");
                    cookie.setMaxAge(30 * 60);
                    resp.addCookie(adminCookie);
                }
                resp.addCookie(cookie);
                map.put("success", true);
                map.put("message", "登陆成功");
                map.put("token", token);
                userService.getUpdateOperation(userService.getSelectAccount(account).getId(),
                        "登录系统:"+
                                (java.time.LocalDateTime.now().
                                        format(java.time.format.DateTimeFormatter.
                                                ofPattern("yyyy-MM-dd HH:mm:ss"))+"\n"+
                                                "登录IP:"+ request.getIPv4(req))
                );
            }} else {
                map.put("success", false);
                map.put("message", "登录失败，请检查用户名和密码");
            }
            String json = JSON.toJSONString(map);
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write(json);
        }
}
