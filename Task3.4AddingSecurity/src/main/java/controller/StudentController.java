package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public String listStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }
}
