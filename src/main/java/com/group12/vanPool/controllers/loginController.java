package com.group12.vanPool.controllers;

import com.group12.vanPool.business.service.UserServiceImplemented;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


@Controller
@RequestMapping("")
public class loginController {



    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @PostMapping("/login-test")
    public ModelAndView finishedLogin(ModelAndView model)
    {
        return model;
    }

}
