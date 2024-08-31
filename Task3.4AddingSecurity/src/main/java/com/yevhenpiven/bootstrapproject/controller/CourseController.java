package com.yevhenpiven.bootstrapproject.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", new ArrayList<>());
        return "courses";
    }
}
