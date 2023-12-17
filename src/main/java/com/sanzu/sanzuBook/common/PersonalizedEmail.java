package com.sanzu.sanzuBook.common;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.*;

@WebServlet("/api/email")
public class PersonalizedEmail extends HttpServlet {
    private static final String MAIL_SERVER_HOST = "smtp.qq.com";
    private static  String title = "";
    private static String content = "";
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Properties prop = new Properties();
        prop.put("mail.smtp.port", 587);
        prop.setProperty("mail.debug", "true");
        prop.setProperty("mail.host", MAIL_SERVER_HOST);
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        String to = req.getParameter("email");
        title = req.getParameter("title");
        content = req.getParameter("content");
        //sender email
        String from = "sanzureading@qq.com";
        // 1、创建session
        Session session = Session.getInstance(prop);
        Transport ts = null;

        // 2、通过session得到transport对象
        try {
            ts = session.getTransport();
            // 3、连上邮件服务器
            ts.connect(MAIL_SERVER_HOST, from, "xbddedytsgmcbceg");

            // 4、创建邮件
            MimeMessage message = new MimeMessage(session);

            // 邮件消息头
            message.setFrom(new InternetAddress(from)); // 邮件的发件人
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 邮件的收件人
            message.setSubject("匿名信箱", "UTF-8");
            // 邮件消息体
            String htmlContent = generateHtmlContent(); // 生成包含验证码的HTML内容

            // 设置邮件内容为HTML格式
            message.setContent(htmlContent, "text/html;charset=utf-8");

            // 5、发送邮件
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
            resp.getWriter().write(JSON.toJSONString("发送成功！"));
        } catch (MessagingException e) {
            resp.getWriter().write(JSON.toJSONString("发送失败！"));
        }
    }
    private String generateHtmlContent() {
        return "<h2 style=\"color:rgb(101, 100, 191);font-weight: bold;\">" + title + "</h2>\n"+
                "<h4 style=\"color:rgb(101, 100, 191);font-weight: bold;\">" + content + "</h4>\n"
                ;
    }
}
