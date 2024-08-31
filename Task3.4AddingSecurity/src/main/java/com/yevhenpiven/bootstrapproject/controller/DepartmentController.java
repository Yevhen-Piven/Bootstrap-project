package com.yevhenpiven.bootstrapproject.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepartmentController {

    @GetMapping("/departments")
    public String listDepartments(Model model) {
        model.addAttribute("departments", new ArrayList<>());
        return "departments";
    }
}
