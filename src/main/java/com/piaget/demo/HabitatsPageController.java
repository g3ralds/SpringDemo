package com.piaget.demo;

import com.piaget.demo.entities.Habitat;
import com.piaget.demo.repositories.HabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HabitatsPageController {

    private HabitatRepository habitatRepository;

    @GetMapping("/habitatspage")
    public String habitats(Model model)
    {
        return "habitatspage";
    }

    @PostMapping("/habitatspage")
    public String goToHabitats(Model model)
    {
        return "habitatspage";
    }

    @Autowired
    public HabitatsPageController(HabitatRepository habitatRepository) {
        this.habitatRepository = habitatRepository;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Habitat habitat) {
        return "add-habitat";
    }

    @PostMapping("/addHabitat")
    public String addHabitat(@Valid Habitat habitat, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-habitat";
        }

        habitatRepository.save(habitat);
        model.addAttribute("habitats", habitatRepository.findAll());

        // obter todos os animais
        //List<Animal> animals = animalRepository.findAll();


        // calcular o seu nivel de satisfação


        return "animalspage";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Habitat habitat = habitatRepository.findById(id);
        model.addAttribute("habitat", habitat);
        return "update-habitat";
    }

    @PostMapping("/update/{id}")
    public String updateHabitat(@PathVariable("id") long id, @Valid Habitat habitat, BindingResult result, Model model) {
        if (result.hasErrors()) {
            habitat.setId(id);
            return "update-habitat";
        }

        habitatRepository.save(habitat);
        model.addAttribute("habitats", habitatRepository.findAll());
        return "habitatspage";
    }

    @GetMapping("/delete/{id}")
    public String deleteHabitat(@PathVariable("id") long id, Model model) {
        Habitat habitat = habitatRepository.findById(id);
        habitatRepository.delete(habitat);
        model.addAttribute("habitats", habitatRepository.findAll());
        return "habitatspage";
    }
}
