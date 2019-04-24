package com.group12.vanPool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rideSearch")
public class rideSearchController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayRides(ModelAndView model) {
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView joinRide() {
        ModelAndView model = new ModelAndView("riderHomepage");


        return model;
    }
}
