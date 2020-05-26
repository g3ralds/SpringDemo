package com.piaget.demo;

import com.piaget.demo.entities.Animal;
import com.piaget.demo.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AnimalsPageController {

    @GetMapping("/animalspage")
    public String animals(Model model)
    {
        return "animalspage";
    }

    @PostMapping("/animalspage")
    public String goToAnimals(Model model)
    {
        return "animalspage";
    }

    private AnimalRepository animalRepository;

    @Autowired
    public AnimalsPageController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Animal animal) {
        return "add-animal";
    }

    @PostMapping("/addAnimal")
    public String addAnimal(@Valid Animal animal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-animal";
        }

        animalRepository.save(animal);
        model.addAttribute("animals", animalRepository.findAll());
        return "animalspage";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Animal animal = animalRepository.findById(id);
        model.addAttribute("animal", animal);
        return "update-animal";
    }

    @PostMapping("/update/{id}")
    public String updateAnimal(@PathVariable("id") long id, @Valid Animal animal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            animal.setId(id);
            return "update-animal";
        }

        animalRepository.save(animal);
        model.addAttribute("animals", animalRepository.findAll());
        return "animalspage";
    }

    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable("id") long id, Model model) {
        Animal animal = animalRepository.findById(id);
        animalRepository.delete(animal);
        model.addAttribute("animals", animalRepository.findAll());
        return "animalspage";
    }

}
