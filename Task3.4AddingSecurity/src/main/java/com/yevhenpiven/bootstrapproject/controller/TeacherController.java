package com.yevhenpiven.bootstrapproject.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherController {

    @GetMapping("/teachers")
    public String listTeachers(Model model) {
        model.addAttribute("teachers", new ArrayList<>());
        return "teachers";
    }
}
