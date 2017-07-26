package com.udemy.controller;

import com.udemy.model.ContactModel;
import com.udemy.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Pablo on 25/07/2017.
 */

@org.springframework.web.bind.annotation.RestController
public class RegistrationController {

    private Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/signup")
    public String signup(){
        return "Por favor, registrate para utilizar este servicio";
    }

    @RequestMapping("/signup-success")
    public String signupSuccess(){
        // Enviar e-mail
        ContactModel contact = new ContactModel();
        contact.setFirstName("Pablo");
        contact.setCity("Santiago");
        contact.setTelephone("67665526");

        try {
            notificationService.sendNotification(contact);
        } catch (MailException e){
            logger.info("Error enviando mails "+e.getMessage());
        }
        return "Gracias por registrarte con nosotros";
    }

}
