package com.group12.vanPool.controllers;

import com.group12.vanPool.UserDto;
import com.group12.vanPool.data.entity.Users;
import com.group12.vanPool.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;

@Controller
@RequestMapping("")
public class signUpController {

    @Autowired
    private UserRepository userRepository;

    public signUpController( ) {
    }

    @GetMapping(value = "/signUp")
    public String showSignUpForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "signUp";
    }

    @PostMapping(value = "/submit-signUp")
    public ModelAndView saveUser(ModelAndView modelAndView, @ModelAttribute("userDto") @Valid final UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/signUp");
        }else {
            Users newUser = new Users();
            newUser.setuName(userDto.getUsername());
            newUser.setPassword(userDto.getPassword());
            newUser.setRemainingSignInAttempts(3);
            userRepository.save(newUser);
            modelAndView.setViewName("/completeSignUp");
        }
        return modelAndView;
    }
}
