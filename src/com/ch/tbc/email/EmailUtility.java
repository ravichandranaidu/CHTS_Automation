
package com.ch.tbc.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility
{
    public static void sendEmail(String subject, String body)
    {
        final String username = "prasannakumarreddygundala@gmail.com";
        final String password = "prasannakumar";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator()
        {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(username, password);
            }
        });

        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("AutomationReports@chtsinc.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(
                    "ravichandra@chtsinc.com"));
            message.setSubject(subject);
            message.setText(body);
            message.setContent(body, "text/html;charset=gb2312");

            Transport.send(message);

            System.out.println("Sent Sucessfully");

        } catch (MessagingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
