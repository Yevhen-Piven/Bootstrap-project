package com.yevhenpiven.bootstrapproject.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
  
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students",  new ArrayList<>());
        return "students";
    }
}
