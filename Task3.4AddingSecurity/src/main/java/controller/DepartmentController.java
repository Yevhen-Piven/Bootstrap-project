package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import service.DepartmentService;

@Controller
public class DepartmentController {

    private DepartmentService departmentService;

    @GetMapping("/departments")
    public String listDepartments(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        return "departments";
    }
}
