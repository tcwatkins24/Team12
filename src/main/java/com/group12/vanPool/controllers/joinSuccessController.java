package com.group12.vanPool.controllers;

import com.group12.vanPool.business.service.RouteServiceImplemented;
import com.group12.vanPool.data.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("joinSuccess")
public class joinSuccessController {

    @Autowired
    RouteServiceImplemented routeServiceImplemented;

    @RequestMapping(method = RequestMethod.GET)
    public String displaySuccess() {
        return "joinSuccess";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String rideJoined(@RequestParam(name = "routeID") String s_rID) {
        List<Route> routes = routeServiceImplemented.getRides();
        Route joinedRoute;
        int rID = Integer.parseInt(s_rID);
        for (Route r : routes) {
            if (r.getId() == rID) {
                joinedRoute = r;
                joinedRoute.setCapacity(r.getCapacity() - 1);
                break;}
        }

        return "joinSuccess";
    }

}
