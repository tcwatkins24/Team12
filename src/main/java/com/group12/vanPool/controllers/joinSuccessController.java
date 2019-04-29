package com.group12.vanPool.controllers;

import com.group12.vanPool.business.service.RouteServiceImplemented;
import com.group12.vanPool.data.entity.JoinedRoute;
import com.group12.vanPool.data.entity.Route;
import com.group12.vanPool.data.repository.JoinedRoutes;
import com.group12.vanPool.data.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("joinSuccess")
public class joinSuccessController {

    @Autowired
    RouteServiceImplemented routeServiceImplemented;
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    JoinedRoutes joinedRoutes;

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
                routeRepository.updateCapacity((r.getCapacity() - 1), rID);
                JoinedRoute jr = new JoinedRoute(r.getId());
                joinedRoutes.save(jr);
                break;
            }
        }

        return "joinSuccess";
    }

}
