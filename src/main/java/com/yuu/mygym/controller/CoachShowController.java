package com.yuu.mygym.controller;

import com.yuu.mygym.pojo.Coach;
import com.yuu.mygym.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CoachShowController {
    private final CoachService coachService;

    /**
     * Constructor-based dependency injection.
     *
     * @param coachService
     */
    @Autowired
    public CoachShowController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/coach")
    public String showCoach(Model model) {
        List<Coach> coaches = coachService.showCoach();
        model.addAttribute("coaches", coaches);
        return "coach";
    }
}
