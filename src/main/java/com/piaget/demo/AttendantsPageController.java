package com.piaget.demo;

import com.piaget.demo.entities.Attendant;
import com.piaget.demo.repositories.AttendantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AttendantsPageController {
    private AttendantRepository attendantRepository;

    @Autowired
    public AttendantsPageController(AttendantRepository repository) {
        this.attendantRepository = repository;
    }


    @GetMapping("/createAttendants")
    public String createAttendants(Attendant attendant) {
        return "add-attendant";
    }


    @PostMapping("/addAttendant")
    public String addAttendant(@Valid Attendant attendant, BindingResult result,  Model model) {
        attendantRepository.save(attendant);
        model.addAttribute("attendants", attendantRepository.findAll());
        return "attendantspage";
    }











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
