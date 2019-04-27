package com.group12.vanPool.controllers;

import com.group12.vanPool.UserDto;
import com.group12.vanPool.business.service.UserServiceImplemented;
import com.group12.vanPool.data.entity.Driver;
import com.group12.vanPool.data.entity.Users;
import com.group12.vanPool.data.repository.DriverRepository;
import com.group12.vanPool.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("")
public class passwordReset {

    @Autowired
    private UserServiceImplemented userServiceImplemented;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value ="/passwordReset")
    public ModelAndView showResetForm() {
       ModelAndView modelAndView = new ModelAndView("passwordReset");
       return modelAndView;
    }


    @PostMapping(value ="/passwordReset")
    public ModelAndView checkUsername(@RequestParam Map<String,String> reqPar){

        ModelAndView model1 = new ModelAndView();
        String username = reqPar.get("username");

        if(userServiceImplemented.checkIfUserExists(username)){
            Users user1 = userServiceImplemented.getByUsername(username);
            String userUsername = user1.getuName();
            String userSecurityQuestion = user1.getSecurityQuestion();

            model1.addObject("userUsername",userUsername);
            model1.addObject("userSecurityQuestion",userSecurityQuestion);
            model1.setViewName("redirect:securityQuestion");

        }else{
            model1.setViewName("redirect:passwordReset?error");

        }
        return  model1;
    }

    @GetMapping(value = "/securityQuestion")
    public ModelAndView showUpdateForm() {
        ModelAndView modelAndView = new ModelAndView("securityQuestion");
        return modelAndView;
    }

    @PostMapping(value = "/securityQuestion")
    public  ModelAndView checkQuestion(@RequestParam Map<String,String> reqPar){

        ModelAndView model1 = new ModelAndView();
        String username = reqPar.get("username");
        String answer = reqPar.get("answer");

        Users user1 = userServiceImplemented.getByUsername(username);
        if(user1.getSecurityAnswer().equals(answer)){
            String userUsername = user1.getuName();
            model1.addObject("userUsername",userUsername);
            model1.setViewName("redirect:changePassword");

        }else{
            String userUsername = user1.getuName();
            String userSecurityQuestion = user1.getSecurityQuestion();
            model1.addObject("userUsername",userUsername);
            model1.addObject("userSecurityQuestion",userSecurityQuestion);
            model1.setViewName("redirect:securityQuestion?error");
        }


        return  model1;

        }

    @GetMapping(value = "/changePassword")
    public ModelAndView showChangePassword() {
        ModelAndView modelAndView = new ModelAndView("changePassword");
        return modelAndView;
    }

    @PostMapping(value = "/changePassword")
    public  ModelAndView changePassword(@RequestParam Map<String,String> reqPar){

        ModelAndView model1 = new ModelAndView();

        String password = reqPar.get("password");
        String confirmPassword = reqPar.get("confirmPassword");

        String username = reqPar.get("username");
        if(password.equals(confirmPassword) && !password.isEmpty()){
            //Query
            userRepository.updatePassword(username,password);

            model1.setViewName("/passwordChangedSuccess");
        }else{
            Users user1 = userServiceImplemented.getByUsername(username);
            String userUsername = user1.getuName();
            model1.addObject("userUsername",userUsername);

            model1.setViewName("redirect:changePassword?error");
        }

        return  model1;

    }

    @GetMapping(value = "/passwordChangedSuccess")
    public ModelAndView showSucess(){
        ModelAndView modelAndView = new ModelAndView("passwordChangedSuccess");
        return modelAndView;
    }
}
