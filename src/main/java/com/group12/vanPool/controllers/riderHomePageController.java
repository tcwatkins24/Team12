package com.group12.vanPool.controllers;

import com.group12.vanPool.business.service.JoinedRoutesImplemented;
import com.group12.vanPool.business.service.RouteService;
import com.group12.vanPool.business.service.RouteServiceImplemented;
import com.group12.vanPool.data.entity.JoinedRoute;
import com.group12.vanPool.data.entity.Route;
import com.group12.vanPool.data.repository.JoinedRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/riderHomePage")
public class riderHomePageController {

    @Autowired
    private RouteServiceImplemented routeServiceImplemented;
    @Autowired
    private JoinedRoutesImplemented JRI;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayRiderHome(){

        ModelAndView model1 = new ModelAndView("riderHomePage");

        List<Route> routesList = routeServiceImplemented.getRides();
        model1.addObject("routes", routesList);
        List<JoinedRoute> jroutes = JRI.getJoinedRoutes();
        List<Route> userJoinedRoutes = new ArrayList<>();
        for (JoinedRoute jr : jroutes) {
            Route r = routeServiceImplemented.getById(jr.getId());
            userJoinedRoutes.add(r);
        }
        model1.addObject("joinedRoutes", userJoinedRoutes);
        return model1;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView searchRide(@RequestParam(name = "startL") String start, @RequestParam(name = "endL") String end) {
        ModelAndView model = new ModelAndView("rideSearch");
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

