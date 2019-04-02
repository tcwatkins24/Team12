package com.group12.vanPool.controllers;

import com.group12.vanPool.data.entity.Route;
import com.group12.vanPool.data.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class adminController {

    @RequestMapping(method = RequestMethod.GET)
    public String displayAdmin(){
        return "admin";
    }



}
