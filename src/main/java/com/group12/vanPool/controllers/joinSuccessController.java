package com.group12.vanPool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("joinSuccess")
public class joinSuccessController {

    @RequestMapping(method = RequestMethod.GET)
    public String displaySuccess() {
        return "joinSuccess";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String rideJoined() {
        return "joinSuccess";
    }

}
