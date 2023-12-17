package com.sanzu.sanzuBook.controller.Login;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sanzu.sanzuBook.common.Email;
import com.sanzu.sanzuBook.common.request;
import com.sanzu.sanzuBook.service.UserService;
import com.sanzu.sanzuBook.service.impl.UserServicelmpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.mail.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/register")
public class getCode extends HttpServlet {
    protected static final Map<String, String> verificationCodeMap = new HashMap<>();
    protected static final Map<String, Timer> timers = new HashMap<>();
    protected void setMap(String key){
        verificationCodeMap.remove(key);
        timers.remove(key);
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(verificationCodeMap);
        resp.setContentType("application/json;charset=UTF-8");
        String Subject = "sanzu Reading";
        String recipient = req.getParameter("email");
        String verificationCode = generateVerificationCode(); // 生成6位随机字母数字验证码
        String htmlContent = generateHtmlContent(verificationCode); // 生成包含验证码的HTML内容
        try {
            Email.sendEmail(Subject,recipient,htmlContent);
            putWithExpiration(recipient, verificationCode); // 5分钟过期
            resp.getWriter().write(JSON.toJSONString("获取成功！"));
        } catch (MessagingException e) {
            resp.getWriter().write(JSON.toJSONString("获取失败！"));
            throw new RuntimeException(e);
        }
    }
    //设置过期时间
    private static void putWithExpiration(String key, String value) {
        verificationCodeMap.put(key, value);

        TimerTask expirationTask = new TimerTask() {
            @Override
            public void run() {
                // 在时间结束时移除字段
                verificationCodeMap.remove(key);
                timers.remove(key);
                System.out.println("Field '" + key + "' removed");
            }
        };

        Timer timer = new Timer();
        timer.schedule(expirationTask, 300000);

        timers.put(key, timer);
    }

    //随机验证码
    private String generateVerificationCode() {
        String characters = "Q123456WERTYUIOPAS123456DFGHJKLZXCVBNM134567qwertyuiopasdfghjklzxcvbnm";
        StringBuilder verificationCode = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            verificationCode.append(characters.charAt(index));
        }
        return verificationCode.toString();
    }
    //html邮件
    private String generateHtmlContent(String verificationCode) {
        return "<html><body><center>" +
                "<img src='http://123.249.68.93:8089/i/2023/11/11/654f8cd8c2b4d.png' height='300' width='1000' alt='Icon'>" +
                "<h1 style=\"color:rgba(104, 103, 187,1);font-weight: bold;\">欢迎注册sanzu Reading，您的验证码是(区分大小写)：</h1>" +
                "<h3 style=\"color:rgb(101, 100, 191);font-weight: bold;\">" + verificationCode + "</h3>\n"+
                "<h5 style=\"color:red;\">验证码5分钟内有效</h5> "+
                "<p style=\"color:red;\">如非本人操作，请立即更改密码。</p> "+
                "</center></body></html>";
    }
    //注册接口（post）
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject json = JSONObject.parseObject(request.requestBody(req,resp));
        // 解析请求体参数
        String userEmail = json.getString("email");
        String username = json.getString("username");
        String code = json.getString("code");
        String password = json.getString("password");
        String avatar = json.getString("avatar");
        if (Authentication(userEmail,code)) {
            verificationCodeMap.remove(userEmail);
            timers.remove(userEmail);
            UserService userService = new UserServicelmpl();
            if(userService.getUserMessage(username)!=null){
                resp.getWriter().write("用户名已被占用,请重新输入！");
            }
            if(userService.getSelectAccount(userEmail)!=null){
                resp.getWriter().write("用户已存在,请返回登录！");
            }
            else {
                Map<String, Object> map = new HashMap<>();
                map.put("account", userEmail);
                map.put("username", username);
                map.put("password", password);
                map.put("avatar", avatar);
                Integer isSuccess = userService.getInsertNewUser(map);
                if (isSuccess == 1) {
                    userService.getUpdateOperation(userService.getSelectAccount(userEmail).getId(),"注册时间:"+java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+"\n"+"请求IP:"+request.getIPv4(req));
                    resp.getWriter().write(JSON.toJSONString("注册成功"));
                } else resp.getWriter().write("注册失败");
            }
        }
        else {
            resp.getWriter().write(JSON.toJSONString("验证码错误！请重新输入"));
    }
}
protected boolean Authentication(String key,String code){
    String realCode = verificationCodeMap.get(key);
    return realCode != null && realCode.equals(code);
}
}