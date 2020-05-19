package com.piaget.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AttendantsPageController {

    @GetMapping("/attendantspage")
    public String attendants(Model model)
    {
        model.addAttribute("attendantspage", new AttendantsPage());
        return "attendantspage";
    }

    @PostMapping("/attendantspage")
    public String goToAnimals(Model model)
    {
        return "attendantspage";
    }
}
