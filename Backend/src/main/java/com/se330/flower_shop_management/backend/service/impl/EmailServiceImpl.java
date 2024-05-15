package com.se330.flower_shop_management.backend.service.impl;

import com.se330.flower_shop_management.backend.dto.UserDto;
import com.se330.flower_shop_management.backend.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String email) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        message.setFrom(new InternetAddress("21522217@gm.uit.edu.vn"));
        message.setRecipients(MimeMessage.RecipientType.TO, email);
        message.setSubject("FlowerFly account verify code");

        String htmlTemplate = readFile("mail_template.html");

        message.setContent(htmlTemplate, "text/html; charset=utf-8");

        this.mailSender.send(message);
    }

    private String readFile(String fileName) {
        return "<h2>FlowerFly account</h2>";
    }
}