package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.TimetableService;

@Controller
@RequestMapping("/templates/timetables.html")
public class TimetableController {

    private final TimetableService timetableService;

    @Autowired
    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    public String listTimetables(Model model) {
        model.addAttribute("timetables", timetableService.findAll());
        return "timetables";
    }
}
