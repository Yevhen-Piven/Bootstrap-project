package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import service.TimetableService;

@Controller
public class TimetableController {

    private TimetableService timetableService;

    @GetMapping("/timetables")
    public String listTimetables(Model model) {
        model.addAttribute("timetables", timetableService.findAll());
        return "timetables";
    }
}
