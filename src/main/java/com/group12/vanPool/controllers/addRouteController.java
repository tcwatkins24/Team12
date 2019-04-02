package com.group12.vanPool.controllers;

import com.group12.vanPool.data.entity.Route;
import com.group12.vanPool.data.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/addRoute")
public class addRouteController {
    @Autowired
    private RouteRepository routeRepository;

    @GetMapping
    public String showAddRoute(Model model) {return "addRoute";}

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView formSubmit(@RequestParam Map<String,String> reqPar){

        Route route = new Route();
        route.setStartLoc(reqPar.get("startLocation"));
        route.setEndLoc(reqPar.get("endLocation"));
        route.setStartPickUpTime(reqPar.get("startPickUpTime"));
        route.setEndPickUpTime(reqPar.get("endPickUpTime"));

        routeRepository.save(route);

        ModelAndView model1 = new ModelAndView("home");
        return model1;
    }
}
