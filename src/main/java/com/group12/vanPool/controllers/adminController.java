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

    @Autowired
    private RouteRepository routeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String displayAdmin(){
        return "admin";
    }

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
