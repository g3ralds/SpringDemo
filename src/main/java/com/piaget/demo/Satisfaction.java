package com.piaget.demo;

import com.piaget.demo.entities.Animal;
import com.piaget.demo.entities.Habitat;

import java.util.List;

public class Satisfaction {

    public static int calculate(Animal animalQueQuerSaberASatisfacao) {
        return 20 + igual(animalQueQuerSaberASatisfacao) - diferente(animalQueQuerSaberASatisfacao) + espaco(animalQueQuerSaberASatisfacao);
    }

    private static int igual(Animal animalQueQuerSaberQuantosAnimaisIguais)
    {
        Habitat habitatDoAnimalQueQuerSaberIguais = animalQueQuerSaberQuantosAnimaisIguais.getHabitat();
        List<Animal> animaisDoMesmoHabitat = habitatDoAnimalQueQuerSaberIguais.getAnimals();

        int contadorDeAnimaisDaMesmaEspecie = 0;

        for (Animal animalQueResideNoMesmoHabitat : animaisDoMesmoHabitat) {
            if (animalQueResideNoMesmoHabitat.getSpecies().equals(animalQueQuerSaberQuantosAnimaisIguais.getSpecies())) {
                contadorDeAnimaisDaMesmaEspecie++;
            }
        }

        // Não se conta com o próprio
        contadorDeAnimaisDaMesmaEspecie--;

        return 3 * contadorDeAnimaisDaMesmaEspecie;
    }

    private static int diferente(Animal animalQueQuerSaberDiferentes) {
        String especieDoAnimalOriginal = animalQueQuerSaberDiferentes.getSpecies();
        Habitat habitatDoAnimalOriginal = animalQueQuerSaberDiferentes.getHabitat();

        List<Animal> animaisDoMesmoHabitat = habitatDoAnimalOriginal.getAnimals();

        int contadorDeAnimaisDiferentes = 0;

        for (int i = 0; i < animaisDoMesmoHabitat.size(); i++) {
            Animal animalQueQueroComparar = animaisDoMesmoHabitat.get(i);
            String especieDoOutroAnimal = animalQueQueroComparar.getSpecies();

            if (!(especieDoAnimalOriginal.equals(especieDoOutroAnimal))) {
                contadorDeAnimaisDiferentes++;
            }
        }

        return 2 * contadorDeAnimaisDiferentes;
    }

    private static int espaco(Animal animalQueMoraNoHabitat) {
        // Saber o número de animais nesse Habitat - População
        // Arredondar (Area / População)

        Habitat habitatOndeMoraOAnimal = animalQueMoraNoHabitat.getHabitat();
        int areaDoHabitat = habitatOndeMoraOAnimal.getArea();
        int numeroDeAnimaisNoHabitat = habitatOndeMoraOAnimal.getAnimals().size();

        int arredondamento = Math.round(areaDoHabitat / numeroDeAnimaisNoHabitat);

        return  arredondamento;
    }
}
