package com.bivashy.learn.pet.entity;

public class Adopter {

    private final int id;
    private final Pet adoptedPet;
    private final String name;

    public Adopter(int id, Pet adoptedPet, String name) {
        this.id = id;
        this.adoptedPet = adoptedPet;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Pet getAdoptedPet() {
        return adoptedPet;
    }

    public String getName() {
        return name;
    }

}
