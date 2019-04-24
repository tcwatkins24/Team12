package com.group12.vanPool.controllers;

import com.group12.vanPool.business.service.DriverServiceImplemented;
import com.group12.vanPool.business.service.UserServiceImplemented;
import com.group12.vanPool.data.entity.Driver;
import com.group12.vanPool.data.entity.Route;
import com.group12.vanPool.data.entity.Users;
import com.group12.vanPool.data.repository.DriverRepository;
import com.group12.vanPool.data.repository.RouteRepository;
import com.group12.vanPool.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/addDriver")
public class addDriverController {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImplemented userServiceImplemented;

    @Autowired
    private DriverServiceImplemented driverServiceImplemented;

    @GetMapping
    public ModelAndView validateDriver() {
        ModelAndView model1 = new ModelAndView("addDriver");

        List<Driver> driverList = driverServiceImplemented.getUnvalidatedDrivers();
        model1.addObject("drivers", driverList);
        return model1;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView formSubmit(@RequestParam Map<String,String> reqPar){
        ModelAndView model1 = new ModelAndView("admin");

        Integer id =  Integer.parseInt(reqPar.get("id"));
        String username = null;
        Optional<Driver> d = driverRepository.findById(id);
        if(d.isPresent()){
            Driver driver = d.get();
            driverRepository.delete(driver);
            driver.setAuth(true);
            username = driver.getUsername();
            driverRepository.save(driver);

            Users u = userServiceImplemented.getByUsername(username);
                userRepository.delete(u);
                userRepository.save(u);
            }
        return model1;
    }

}
