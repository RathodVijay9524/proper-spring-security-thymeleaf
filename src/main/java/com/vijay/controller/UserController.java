package com.vijay.controller;

import com.vijay.dtos.UserDto;
import com.vijay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
        return "register";
    }
    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model){
        userService.addUser(userDto);
        model.addAttribute("msg","Registration successfully");
        return "register";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/user")
    public String userPage ( Model model, Principal principal){
        String name= principal.getName();
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user",userDetails);
        model.addAttribute("name",name);
        return "user";
    }

    @GetMapping("/admin")
    public String adminUser(Model model, Principal principal){
        String name= principal.getName();
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("admin",userDetails);
        model.addAttribute("name",name);
        return "admin";
    }
    @GetMapping("/normal")
    public String NormalUser(Model model, Principal principal){
        String name= principal.getName();
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("normal",userDetails);
        model.addAttribute("name",name);
        return "normal";
    }
}
