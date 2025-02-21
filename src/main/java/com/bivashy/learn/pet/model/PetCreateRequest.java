package com.bivashy.learn.pet.model;

import com.bivashy.learn.pet.entity.Specie;

public class PetCreateRequest {

    private final int shelterId;
    private final Specie specie;
    private final int age;
    private final String description;

    public PetCreateRequest(int shelterId, Specie specie, int age, String description) {
        this.shelterId = shelterId;
        this.specie = specie;
        this.age = age;
        this.description = description;
    }

    public int getShelterId() {

        return shelterId;
    }

    public Specie getSpecie() {
        return specie;
    }

    public int getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

}
