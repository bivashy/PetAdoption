package com.bivashy.learn.pet.entity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Shelter shelter))
            return false;
        return getId() == shelter.getId() && Objects.equals(getName(), shelter.getName()) && Objects.equals(getPets(), shelter.getPets());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPets());
    }

}
