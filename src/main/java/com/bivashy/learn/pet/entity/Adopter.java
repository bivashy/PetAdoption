package com.bivashy.learn.pet.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Adopter adopter))
            return false;
        return getId() == adopter.getId() && Objects.equals(getAdoptedPet(), adopter.getAdoptedPet()) &&
                Objects.equals(getName(), adopter.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAdoptedPet(), getName());
    }

}
