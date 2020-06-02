package com.piaget.demo;

import com.piaget.demo.entities.Animal;
import com.piaget.demo.entities.Habitat;
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
import java.util.List;

@Controller
public class AnimalsPageController {
    public static AnimalRepository animalRepository;

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

        // Ainda não é o código certo, mas está mais perto
        // (O código certo é com uma associação dinamica entre o animal e o habitat, como está neste exemplo:
        // https://howtodoinjava.com/spring-mvc/spring-mvc-populate-and-validate-dropdown-example/
        // )

        List<Habitat> habitatsDaBaseDeDados = HabitatsPageController.habitatRepository.findAll();
        animal.setHabitat(habitatsDaBaseDeDados.get(0));

        List<Animal> animaisDaBaseDeDados = animalRepository.findAll();

        for (Animal animalDaBaseDeDados : animaisDaBaseDeDados) {
            animalDaBaseDeDados.calculateSatisfaction();
        }

        animal.calculateSatisfaction();

        animalRepository.save(animal);

        calculateTotalSatisfaction(model);

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

    private void calculateTotalSatisfaction(Model model) {
        List<Animal> animaisDaBaseDeDados = animalRepository.findAll();

        int satisfacaoAcumulada = 0;

        for (Animal animalDaBaseDeDados : animaisDaBaseDeDados) {
            animalDaBaseDeDados.calculateSatisfaction();
            satisfacaoAcumulada += animalDaBaseDeDados.getSatisfaction();
        }

        int numeroDeAnimais = animaisDaBaseDeDados.size();

        double mediaDaSatisfacao = satisfacaoAcumulada / numeroDeAnimais;

        model.addAttribute("totalSatisfaction", mediaDaSatisfacao);
    }

}
