package com.piaget.demo;

import com.piaget.demo.entities.Animal;
import com.piaget.demo.entities.Habitat;

import java.util.List;

public class Satisfaction {

    public static int calculate(Animal animal) {
        return 20 + igual(animal) - diferente(animal) + espaco(animal);
    }

    private static int igual(Animal animal)
    {
        Habitat habitat = new Habitat();
        List<Animal> animals = habitat.getAnimals();

        int result = 0;
        for (Animal a : animals) {
            if (animal.getSpecies().equals(a.getSpecies())) {
                result++;
            }
        }

        // Não contar consigo próprio
        result--;

        return 3 * result;
    }

    private static int diferente(Animal animal) {
        Habitat habitat = new Habitat();
        List<Animal> animals = habitat.getAnimals();

        int result = 0;
        for (Animal a : animals) {
            if (!animal.getSpecies().equals(a.getSpecies())) {
                result++;
            }
        }

        return 2 * result;
    }

    private static int espaco(Animal animal) {
        Habitat habitat = new Habitat();
        List<Animal> animals = habitat.getAnimals();

        return Math.round(habitat.getArea() / animals.size());
    }

}
