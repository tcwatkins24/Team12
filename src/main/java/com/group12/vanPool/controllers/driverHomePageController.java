package com.group12.vanPool.controllers;

import com.group12.vanPool.business.service.DriverServiceImplemented;
import com.group12.vanPool.business.service.JoinedRoutesImplemented;
import com.group12.vanPool.business.service.RouteServiceImplemented;
import com.group12.vanPool.data.entity.Driver;
import com.group12.vanPool.data.entity.JoinedRoute;
import com.group12.vanPool.data.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.Authenticator;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/driverHomePage")
public class driverHomePageController {

@Autowired private DriverServiceImplemented driverServiceImplemented;

@Autowired private RouteServiceImplemented routeServiceImplemented;

    @Autowired
    private JoinedRoutesImplemented JRI;

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
        List<JoinedRoute> jroutes = JRI.getJoinedRoutes();
        List<Route> userJoinedRoutes = new ArrayList<>();
        for (JoinedRoute jr : jroutes) {
            Route r = routeServiceImplemented.getById(jr.getId());
            userJoinedRoutes.add(r);
        }
        model1.addObject("joinedRoutes", userJoinedRoutes);
        //return model1;


        model1.addObject("validated",validated);
        return model1;
    }


    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView searchRide(@RequestParam(name = "startL") String start, @RequestParam(name = "endL") String end) {
        ModelAndView model = new ModelAndView("driveSearch");
        List<Route> matchedRoutes = new ArrayList<>();
        List<Route> allRoutes = routeServiceImplemented.getRides();
        for (Route r : allRoutes) {
            if (r.getStartLoc().equals(start) && r.getEndLoc().equals(end)) {
                matchedRoutes.add(r);
            }
        }

        model.addObject("matchedRoutes", matchedRoutes);
        return model;
    }
}

