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
        model.addAttribute("animalspage", new AnimalsPage());
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
        return "add-user";
    }

    @PostMapping("/addAnimal")
    public String addUser(@Valid Animal animal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-animal";
        }

        animalRepository.save(animal);
        model.addAttribute("animals", animalRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Animal animal = animalRepository.findById(id);
        model.addAttribute("user", animal);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Animal animal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            animal.setId(id);
            return "update-user";
        }

        animalRepository.save(animal);
        model.addAttribute("users", animalRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Animal animal = animalRepository.findById(id);
        animalRepository.delete(animal);
        model.addAttribute("users", animalRepository.findAll());
        return "index";
    }

}
