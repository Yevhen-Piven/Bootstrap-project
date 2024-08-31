package com.yevhenpiven.bootstrapproject.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassroomController {
   
    @GetMapping("/classrooms")
    public String listClassrooms(Model model) {
        model.addAttribute("classrooms", new ArrayList<>());
        return "classrooms";
    }
}
