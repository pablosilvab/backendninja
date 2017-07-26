package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.internet.MimeMessage;

/**
 * Created by Pablo on 25/07/2017.
 */
@Controller
public class SimpleEmailController {

    @Autowired
    private JavaMailSender sender;

    @RequestMapping("/simpleemail")
    @ResponseBody
    String home(){
        try{
            sendMail();
            return "Email sent!";
        } catch (Exception e){
            return "Error enviando mail "+e;
        }
    }

    private void sendMail() throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo("pablonicolasssilvabravo@gmail.com");
        helper.setText("Quien eres?");
        helper.setSubject("Hola");

        sender.send(message);
    }

}
