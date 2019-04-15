package com.group12.vanPool.controllers;

import com.group12.vanPool.business.service.RouteServiceImplemented;
import com.group12.vanPool.data.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/driverHomePage")
public class driverHomePageController {



    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayRiderHome(){

        ModelAndView model1 = new ModelAndView("driverHomePage");
        return model1;
    }
}

