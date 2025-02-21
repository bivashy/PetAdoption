package com.bivashy.learn.pet.entity;

import java.util.Collections;
import java.util.List;

public class Shelter {

    private final int id;
    private final String name;
    private final List<Pet> pets;

    public Shelter(int id, String name, List<Pet> pets) {
        this.id = id;
        this.name = name;
        this.pets = pets;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Pet> getPets() {
        return Collections.unmodifiableList(pets);
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
    }

}
