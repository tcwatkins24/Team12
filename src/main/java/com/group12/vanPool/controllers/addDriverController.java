package com.group12.vanPool.controllers;

import com.group12.vanPool.data.entity.Driver;
import com.group12.vanPool.data.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/addDriver")
public class addDriverController {

    @Autowired
    private DriverRepository driverRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAddDriver(){
        ModelAndView model = new ModelAndView("addDriver");

        /* test code
        Driver A = new Driver();
        A.setdName("Bob Job");
        A.setUsername("DriftKing2001");
        A.setAuth(false);
        this.driverRepository.save(A);
         end test code*/

        Iterable<Driver> drivers = this.driverRepository.findAll();
        List<Driver> newDrivers = new ArrayList<>();
        for (Driver d : drivers) {
            if (!d.getAuth()) newDrivers.add(d);
        }
        model.addObject("drivers", newDrivers);
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView driverAuth(@RequestParam(name= "dUser") String dUsername) {


        ModelAndView model = new ModelAndView("home");
        return model;
    }


}
