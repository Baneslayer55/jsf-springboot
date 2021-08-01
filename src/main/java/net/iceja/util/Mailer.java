/*
Copyright (c) 2019 Ekaterina Alexeevna Ivanova  (iceja.moscow). All rights reserved.
PROPRIETARY. For demo purposes only, not for redistribution or any commercial use.
*/

package net.iceja.util;

/*
    @author Ekaterina (iceja.net) Ivanova


 */

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class Mailer {
    public static void send(String sender, String textik) {
        final String password = "aki90g0"; // correct password for gmail id
        final String toEmail = "ekaterina_ivanova@live.com"; // can be any email id
        String username = "iceja13";
        Properties props = new Properties();
        props.setProperty("mail.mime.charset", "UTF-8");
        props.put("mail.smtp.host", "smtp.yandex.ru"); //SMTP Host
        props.put("mail.smtp.port", "465"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
        Session session = Session.getInstance(props, auth);
        sendEmail(session, toEmail,"Сообщение от поситителя сайта - " + sender, textik);

    }

    /**
     * Utility method to send simple HTML email
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     */
    public static void sendEmail(Session session, String toEmail, String subject, String body){
        try
        {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("iceja13@yandex.ru", "От меня"));
            msg.setReplyTo(InternetAddress.parse("iceja13@yandex.ru", false));
            msg.setSubject(subject, "UTF-8");
            msg.setText(body, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            Transport.send(msg);
            System.out.println("EMail Sent Successfully!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
