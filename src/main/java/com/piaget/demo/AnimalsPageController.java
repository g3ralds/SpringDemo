package com.piaget.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimalsPageController {

    @GetMapping("/animalspage")
    public String animals(Model model)
    {
        model.addAttribute("animalspage", new AnimalsPage());
        return "animalspage";
    }
}
