package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.CourseService;

@Controller
@RequestMapping("/Task3.4AddingSecurity/src/main/resources/templates/courses.html")
public class CourseController {
    private CourseService courseService;

    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "courses";
    }
}
