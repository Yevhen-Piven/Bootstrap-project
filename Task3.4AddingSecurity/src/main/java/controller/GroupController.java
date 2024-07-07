package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.GroupService;

@Controller
@RequestMapping("/groups")
public class GroupController {
    private GroupService groupService;

    public String listGroups(Model model) {
        model.addAttribute("groups", groupService.findAll());
        return "groups";
    }
}
