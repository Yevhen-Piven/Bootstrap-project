package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import service.CourseService;

@Controller
@RequestMapping("/templates/courses")
public class CourseController {
    private CourseService courseService;

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "courses";
    }
}
