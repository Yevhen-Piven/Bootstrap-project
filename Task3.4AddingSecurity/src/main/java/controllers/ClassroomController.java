package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Classroom;
import service.ClassroomService;

@Controller
@RequestMapping("/classrooms")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping
    public String listClassrooms(Model model) {
        List<Classroom> classrooms = classroomService.findAll();
        model.addAttribute("classrooms", classrooms);
        return "classrooms";
    }
}
