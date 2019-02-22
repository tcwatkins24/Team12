package com.group12.vanPool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class signUpController {

    @GetMapping
    public String signUp(Model model){
        return "signup";
    }
}
