package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import service.TeacherService;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    
    @Value("${Bootstrap Spring Boot}")
    String appName;
    
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public String listTeachers(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "teachers";
    }
}
