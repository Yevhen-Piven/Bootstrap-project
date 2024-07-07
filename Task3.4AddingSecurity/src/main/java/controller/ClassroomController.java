package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ClassroomService;

@Controller
@RequestMapping("/Task3.4AddingSecurity/classrooms")
public class ClassroomController {
    private ClassroomService classroomService;

    public String listClassrooms(Model model) {
        model.addAttribute("classrooms", classroomService.findAll());
        return "classrooms";
    }
}
