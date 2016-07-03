package com.sample;



import org.rythmengine.Rythm;
import org.rythmengine.RythmEngine;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by FaustineP™ on 1/5/2015.
 */
public class Main {

    public static void main(String args[]) {
        Session session = setGOOGLESMTPConfig();
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sandesh.dsouza@gmail.com"));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("sandesh.dsouza@gmail.com"));
            String subject = String.format("[%s]", "Rythm Engine Template Email");
            message.setSubject(subject);
            
            Map conf = new HashMap();
            conf.put("home.template.dir", new File("C:\\").getAbsolutePath());
            RythmEngine engine = new RythmEngine(conf);
            Student student = new Student(2061435412, "Student Name", 25, "BS Computer Science");
            String note = "* This is a system generated email do not reply";
            File template = new File(String.valueOf(Main.class.getClassLoader().getResource("content.html").getFile()));
            String bodyContent = engine.render(template, student, note);
            message.setContent(bodyContent, "text/html; charset=utf-8");
            javax.mail.Transport.send(message);
            System.out.println("[Message sent!]");
        } catch (MessagingException e) {
            System.out.println(e);
        }
    }

    private static Session setGOOGLESMTPConfig() {
        final Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", String.valueOf("587"));
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sandesh.dsouza@gmail.com", "oassword");
            }
        });
    }

}
