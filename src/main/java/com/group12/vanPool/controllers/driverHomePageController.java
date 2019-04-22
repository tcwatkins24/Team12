package com.group12.vanPool.controllers;

import com.group12.vanPool.business.service.DriverServiceImplemented;
import com.group12.vanPool.business.service.RouteServiceImplemented;
import com.group12.vanPool.data.entity.Driver;
import com.group12.vanPool.data.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.net.Authenticator;
import java.util.List;


@Controller
@RequestMapping("/driverHomePage")
public class driverHomePageController {

@Autowired private DriverServiceImplemented driverServiceImplemented;

@Autowired private RouteServiceImplemented routeServiceImplemented;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayRiderHome(Authentication authentication){

        ModelAndView model1 = new ModelAndView("driverHomePage");

        Boolean validated = false;
        String username = authentication.getName();
        List<Driver> driverList = driverServiceImplemented.getDrivers();
        for (Driver d:driverList
             ) {
            if(d.getUsername().equals(username)){
                validated = d.getAuth();
            }
        }

        List<Route> routesList = routeServiceImplemented.getRides();
        model1.addObject("routes", routesList);



        model1.addObject("validated",validated);
        return model1;
    }
}

