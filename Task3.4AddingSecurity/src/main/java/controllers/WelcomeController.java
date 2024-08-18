package controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @Value("${Bootstrap Spring Boot}")
    String appName;

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("message", "Welcome to Bootstrap Spring Boot");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
