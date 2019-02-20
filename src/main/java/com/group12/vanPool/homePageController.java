package com.group12.vanPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class homePageController {

    @Autowired
    public homePageController(){
        super();
    }

    @GetMapping
    public String homePage(Model model){
        return "homePage/index.html";
    }
}
