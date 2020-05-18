package com.piaget.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttendantsPageController {

    @GetMapping("/attendantspage")
    public String attendants(Model model)
    {
        model.addAttribute("attendantspage", new AttendantsPage());
        return "attendantspage";
    }
}
