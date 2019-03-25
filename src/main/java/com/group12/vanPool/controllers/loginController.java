package com.group12.vanPool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/login")
public class loginController {

    @GetMapping
    public String login(Model model){
        return "login";
    }

    @PostMapping(value = "/login")
    public ModelAndView finishedLogin(ModelAndView modelAndView){
        modelAndView.setViewName("/riderHomePage");
        return modelAndView;
    }

}
