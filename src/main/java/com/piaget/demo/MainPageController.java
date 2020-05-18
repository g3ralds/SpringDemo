package com.piaget.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainPageController {

    @GetMapping("/mainpage")
    public String hello(Model model)
    {
        model.addAttribute("mainpage", new MainPage());
        return "mainpage";
    }

    @PostMapping("/mainpage")
    public String goTo(@ModelAttribute MainPage mainPage) {

        return "animalspage";

//        if (mainPage.getPagename().equals("AnimalsPage")) {
//            return "animalspage";
//        } else if (mainPage.getPagename().equals("HabitatsPage")) {
//            return "habitatspage";
//        } else if (mainPage.getPagename().equals("AttendantsPage")) {
//            return "attendantspage";
//        } else {
//            return "mainpage";
//        }
    }

}
