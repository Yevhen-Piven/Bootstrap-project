package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import service.GroupService;

@Controller
public class GroupController {
    private GroupService groupService;

    @GetMapping("/groups")
    public String listGroups(Model model) {
        model.addAttribute("groups", groupService.findAll());
        return "groups";
    }
}
