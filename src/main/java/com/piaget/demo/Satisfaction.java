package com.piaget.demo;

import com.piaget.demo.entities.Animal;
import com.piaget.demo.entities.Habitat;

import java.util.List;

public class Satisfaction {

    public static int calculate(Animal animal) {
        return 20 + igual(animal) - diferente(animal) + espaco(animal);
    }

    public static int igual(Animal animal)
    {
        Habitat habitat = animal.getHabitat();
        List<Animal> animals = habitat.getAnimals();

        int result = 0;
        for (Animal a : animals) {
            if (animal.getSpecies().EqualsTo(a.getSpecies())) {
                result++;
            }
        }

        return 3 * result;
    }

    public static int diferente(Animal animal) {

    }

}
