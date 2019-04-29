package com.group12.vanPool.controllers;

import com.group12.vanPool.business.service.JoinedRoutesImplemented;
import com.group12.vanPool.data.entity.JoinedRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/balance")
public class balanceController {

    @Autowired
    private JoinedRoutesImplemented JRI;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showBalance() {
        ModelAndView model = new ModelAndView("balance");
        double balance = 0.0;
        Iterable<JoinedRoute> jroutes = JRI.getJoinedRoutes();
        for (JoinedRoute jr : jroutes) {
            balance += 12.50;
        }
        model.addObject("balance", balance);
        return model;
    }

}
