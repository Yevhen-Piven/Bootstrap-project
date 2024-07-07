package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.DepartmentService;

@Controller
@RequestMapping("/Task3.4AddingSecurity/src/main/resources/templates/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public String listDepartments(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        return "departments";
    }
}
