package com.yevhenpiven.bootstrapproject.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimetableController {
    
    @GetMapping("/timetables")
    public String listTimetables(Model model) {
        model.addAttribute("timetables",  new ArrayList<>());
        return "timetables"; 
    }
}
