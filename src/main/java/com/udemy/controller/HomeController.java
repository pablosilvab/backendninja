package com.udemy.controller;

import com.udemy.constant.ViewConstant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Pablo on 18/08/2017.
 */
@Controller
public class HomeController {


    private static final Log LOG = LogFactory.getLog(HomeController.class);


    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView(ViewConstant.HOME);

        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername());
        //mav.addObject("contacts", contactService.listAllContacts());
        return mav;
    }
}
