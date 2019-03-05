package com.group12.vanPool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendVerificationEmail() throws MessagingException {

/*
        SimpleMailMessage verificationEmail=new SimpleMailMessage();
        verificationEmail.setFrom("644770328@qq.com");
        verificationEmail.setTo("xiaotao-li@uiowa.edu");
        verificationEmail.setSubject("VanPool Verification Code");
        verificationEmail.setText("Verification Code is 0000");
        mailSender.send(verificationEmail);*/
        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
        message.setFrom("644770328@qq.com");
        message.setTo("xiaotao-li@uiowa.edu");
        message.setSubject("VanPool Verification Code");
        message.setText("Verification Code is 0000");

        mailSender.send(mimeMessage);

        System.out.println("Successful");
    }

}

