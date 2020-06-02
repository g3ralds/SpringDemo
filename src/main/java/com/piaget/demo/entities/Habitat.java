package com.piaget.demo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Habitat {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;
    private String avatar;
    private int area;

    @OneToMany
    private List<Animal> animals = new ArrayList<Animal>();

    public Habitat() { }

    public Habitat(String name, int area) {
        this.name = name;
        this.area = area;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
