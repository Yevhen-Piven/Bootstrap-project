package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import entity.User;
import service.ClassroomService;

@Controller
public class ClassroomController {
    private ClassroomService classroomService;

    @GetMapping("/classrooms")
    public String listClassrooms(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("classrooms", classroomService.findAll());
        return "classrooms";
    }
}
