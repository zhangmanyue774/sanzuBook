package com.sanzu.sanzuBook.common;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
    private static final String MAIL_SERVER_HOST = "smtp.qq.com";
    private static final String from = "sanzureading@qq.com";
    private static final String key = "xbddedytsgmcbceg";

    /**
     *
     * @param recipient 收件人
     * @param htmlContent 邮件内容
     * @throws MessagingException 发送结果异常
     */
    public static void sendEmail(String Subject,String recipient,String htmlContent) throws MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.port", 587);
        prop.setProperty("mail.debug", "true");
        prop.setProperty("mail.host", MAIL_SERVER_HOST);
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");

        // 1、创建session
        Session session = Session.getInstance(prop);
        Transport ts = null;
        //获取transport对象
        ts = session.getTransport();
        //连接邮件服务器
        ts.connect(MAIL_SERVER_HOST,from,key);
        //创建邮件
        MimeMessage message = new MimeMessage(session);

        //邮件消息头
        message.setFrom(new InternetAddress(from));//发件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));//收件人
        message.setSubject(Subject, "UTF-8");
        //邮件内容
        message.setContent(htmlContent,"text/html;charset=UTF-8");
        //发送邮件
        ts.sendMessage(message,message.getAllRecipients());
        ts.close();
    }
}
