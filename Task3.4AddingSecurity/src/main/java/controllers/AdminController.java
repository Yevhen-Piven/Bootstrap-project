package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.User;
import service.UserService;

@Controller
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @PostMapping("/admin/addUser")
    public String addUser(@ModelAttribute User user, Model model) {
        userService.saveUser(user);
        model.addAttribute("message", "User added successfully");
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @PostMapping("/admin/assignRole")
    public String assignRole(@RequestParam String username, @RequestParam String roleName, Model model) {
        userService.assignRoleToUser(username, roleName);
        model.addAttribute("message", "Role assigned successfully");
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }
}
