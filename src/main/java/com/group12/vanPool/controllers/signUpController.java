package com.group12.vanPool.controllers;

import com.group12.vanPool.UserDto;
import com.group12.vanPool.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.validation.Valid;

@Controller
@RequestMapping("")
public class signUpController {

    private EmailService emailService;

    public signUpController( EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping(value = "/signUp")
    public String showSignUpForm(WebRequest request, Model model) throws MessagingException {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "signUp";
    }

    @PostMapping(value = "/submit-signUp")
    public ModelAndView saveUser(ModelAndView modelAndView, @ModelAttribute("userDto") @Valid final UserDto userDto) {

        modelAndView.setViewName("/signUp");
        return modelAndView;
    }
}
