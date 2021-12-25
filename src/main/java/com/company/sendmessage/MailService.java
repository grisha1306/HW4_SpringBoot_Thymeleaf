package com.company.sendmessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class MailService{

//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Value("${spring.mail.host}")
//    private String host;
//
//    @Value("${spring.mail.username}")
//    private String username;
//
//    @Value("${spring.mail.password}")
//    private String password;
//
//    @Value("${spring.mail.protocol}")
//    private String protocol;
//
//    @Value("${spring.mail.port}")
//    private int port;


    public void send(String emailTo, String subject, String message) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("vasiliy.pupkin1306@gmail.com");
        mailSender.setPassword("Pavlotti130696");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("vasiliy.pupkin1306@gmail.com");
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }

}