package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ClassroomService;

@Controller
@RequestMapping("/classrooms")
public class ClassroomController {
    private ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping
    public String listClassrooms(Model model) {
        model.addAttribute("classrooms", classroomService.findAll());
        return "classrooms";
    }
}
