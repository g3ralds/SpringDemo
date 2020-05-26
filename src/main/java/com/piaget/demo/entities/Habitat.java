package com.piaget.demo.entities;

import java.util.List;

public class Habitat {

    List<Animal> animals;

    private String name;
    private int area;

    public String getName() {
        return name;
    }

    public Habitat() {
    }

    public Habitat(String name, int area) {
        this.name = name;
        this.area = area;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

}
