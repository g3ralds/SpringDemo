package com.piaget.demo.entities;

import com.piaget.demo.Satisfaction;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String name;
    private String species;
    private int age;
    private String avatar;
    private int satisfaction;

    @OneToOne
    private Habitat habitat;

    protected Animal() {}

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public Habitat getHabitat() {
        return this.habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return String.format("Animal[id=%d, name='%s', species='%s']", id, name, species);
    }

    public void calculateSatisfaction() {
        satisfaction = Satisfaction.calculate(this);
    }
}
