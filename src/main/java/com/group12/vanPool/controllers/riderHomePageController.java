package com.group12.vanPool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/riderHomePage")
public class riderHomePageController {

    @GetMapping(value= "/riderHomePage")
    public String riderHomePage(Model model){
        return "riderHomePage";
    }
}

