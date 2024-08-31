package com.yevhenpiven.bootstrapproject.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroupController {
  
    @GetMapping("/groups")
    public String listGroups(Model model) {
        model.addAttribute("groups",  new ArrayList<>());
        return "groups";
    }
}
