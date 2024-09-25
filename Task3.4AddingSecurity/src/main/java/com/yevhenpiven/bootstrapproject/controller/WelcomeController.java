package com.yevhenpiven.bootstrapproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    
    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("message", "Welcome to Bootstrap Spring Boot");
        return "index";
    }
 }