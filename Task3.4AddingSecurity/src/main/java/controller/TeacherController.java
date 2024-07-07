package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import service.TeacherService;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    private TeacherService teacherService;

    @GetMapping
    public String listTeachers(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "teachers";
    }
}
