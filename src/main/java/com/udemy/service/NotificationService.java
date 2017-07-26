package com.udemy.service;

import com.udemy.model.ContactModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Pablo on 25/07/2017.
 */
@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender= javaMailSender;
    }

    public void sendNotification(ContactModel contact){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("pablonicolassilvabravo@gmail.com");
        mail.setFrom("pablonicolassilvabravo@gmail.com");
        mail.setSubject("Probando Subject");
        mail.setText("Probando Set Text. Cool mail notification");

        javaMailSender.send(mail);
    }



}
