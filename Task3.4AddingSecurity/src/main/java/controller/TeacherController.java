package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import service.TeacherService;

@Controller
public class TeacherController {
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public String listTeachers(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "teachers";
    }
}
