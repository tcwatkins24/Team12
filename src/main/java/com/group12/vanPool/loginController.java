package com.group12.vanPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class loginController {

    @Autowired
    public loginController(){
        super();
    }

    @GetMapping
    public String login(Model model){
        return "login/login.html";
    }
}
