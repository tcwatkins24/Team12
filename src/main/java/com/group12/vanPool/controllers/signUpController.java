package com.group12.vanPool.controllers;

import com.group12.vanPool.UserDto;
import com.group12.vanPool.data.entity.Driver;
import com.group12.vanPool.data.entity.Users;
import com.group12.vanPool.data.repository.DriverRepository;
import com.group12.vanPool.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.provisioning.JdbcUserDetailsManager;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class signUpController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    DriverRepository driverRepository;

    public signUpController( ) {
    }

    @GetMapping(value = "/signUp")
    public String showSignUpForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "signUp";
    }

    @PostMapping(value = "/submit-signUp")
    public ModelAndView saveUser(ModelAndView modelAndView, @ModelAttribute("userDto") @Valid final UserDto userDto, BindingResult bindingResult,
                                 @RequestParam(name = "yes_no") String isDriver) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/signUp");
        }else {
            Users newUser = new Users();
            newUser.setuName(userDto.getUsername());
            newUser.setPassword(userDto.getPassword());
            newUser.setRemainingSignInAttempts(3);
            newUser.setSecurityQuestion(userDto.getSecurityQuestion());
            newUser.setSecurityAnswer(userDto.getSecurityAnswer());

            if (isDriver.equals("yes")) {
                newUser.setCurrentUserType(1);

                Driver newDriver = new Driver();
                newDriver.setdName(userDto.getFirstName() + " " + userDto.getLastName());
                newDriver.setUsername(userDto.getUsername());
                driverRepository.save(newDriver);
            }
            userRepository.save(newUser);

            modelAndView.setViewName("/completeSignUp");
        }
        return modelAndView;
    }
}
