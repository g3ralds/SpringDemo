package com.piaget.demo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Habitat {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<Animal> animals = new ArrayList<Animal>();

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

    public void addAnimals(Animal animal) {
        this.animals.add(animal);
    }

    public void setId(long id) {
        this.id = id;
    }

}
