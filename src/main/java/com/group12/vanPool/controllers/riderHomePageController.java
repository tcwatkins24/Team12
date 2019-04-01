package com.group12.vanPool.controllers;

import com.group12.vanPool.business.service.RouteService;
import com.group12.vanPool.business.service.RouteServiceImplemented;
import com.group12.vanPool.data.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/riderHomePage")
public class riderHomePageController {

    @Autowired
    private RouteServiceImplemented routeServiceImplemented;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayRiderHome(){

        ModelAndView model1 = new ModelAndView("riderHomePage");

        List<Route> routesList = routeServiceImplemented.getRides();
        model1.addObject("routes", routesList);
        return model1;
    }
}

