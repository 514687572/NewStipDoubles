package com.stip.net.utils;


import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

/**
 * @Package: com.stip.net.utils
 * @Description:
 * @Author: cgnet05
 * @CreatDate: 2019/01/23
 */
public class JavaMailSenderUtil {

    private static final String SEND_HOST_NAME = ConfigUtils.get("mail.smtp.host");
    private static final String USER = ConfigUtils.get("user");
    private static final String USER_NAME = ConfigUtils.get("userName");
    private static final String PASSWORD = ConfigUtils.get("password");
    private static final String SEND_PROTOCOL = ConfigUtils.get("mail.transport.protocol");
    private static final String PORT = ConfigUtils.get("mail.smtp.port");

    /**
     * 发送邮件
     *
     * @param to
     * @param subject
     * @param content
     * @return
     */
    public static Boolean send(String to, String subject, String content) {
        Properties prop = new Properties();
        prop.setProperty("mail.host", SEND_HOST_NAME);
        prop.setProperty("mail.transport.protocol", SEND_PROTOCOL);
        prop.setProperty("mail.smtp.auth", "true");
        prop.setProperty("mail.smtp.port", PORT);
        prop.setProperty("mail.smtp.socketFactory.class", ConfigUtils.get("mail.smtp.socketFactory.class"));
        prop.setProperty("mail.smtp.socketFactory.fallback", "false");
        prop.setProperty("mail.smtp.socketFactory.port", PORT);
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = null;
        try {
            ts = session.getTransport();
            //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
            ts.connect(SEND_HOST_NAME, USER_NAME, PASSWORD);
            //4、创建邮件
            MimeMessage message = new MimeMessage(session);
            //指明邮件的发件人
            message.setFrom(new InternetAddress(USER_NAME, USER));
            //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //邮件的标题
            message.setSubject(subject);
            //邮件的文本内容
            message.setContent(content, "text/html;charset=UTF-8");
            message.setSentDate(new Date());
            /*5.保存邮件*/
            message.saveChanges();

            //发送邮件
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        /**
         * 设置smtp服务器以及邮箱的帐号和密码
         * 用QQ 邮箱作为发生者不好使 （原因不明）
         * 163 邮箱可以，但是必须开启  POP3/SMTP服务 和 IMAP/SMTP服务
         * 因为程序属于第三方登录，所以登录密码必须使用163的授权码
         */
        // 注意： [授权码和你平时登录的密码是不一样的]
        JavaMailSenderUtil.send("877495411@qq.com", "hi", "111");

    }

    /**
     * 身份认证内部类
     */
    class MailAuthenticator extends Authenticator {
        private String strUser;
        private String strPwd;

        public MailAuthenticator() {
            super();
        }

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            String username = this.strUser;
            String password = this.strPwd;
            if ((username != null) && (username.length() > 0) && (password != null) && (password.length() > 0)) {

                return new PasswordAuthentication(username, password);
            }

            return null;
        }

        public MailAuthenticator(String user, String password) {
            this.strUser = user;
            this.strPwd = password;
        }
    }
}
