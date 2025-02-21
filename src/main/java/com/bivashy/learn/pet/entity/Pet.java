package com.bivashy.learn.pet.entity;

import java.util.Objects;

public class Pet {

    private final int id;
    private final Specie specie;
    private final int age;
    private final String description;

    public Pet(int id, Specie specie, int age, String description) {
        this.id = id;
        this.specie = specie;
        this.age = age;
        this.description = description;
    }

    public Pet(int id, Specie specie, int age) {
        this.id = id;
        this.specie = specie;
        this.age = age;
        this.description = "-";
    }

    public int getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Pet pet))
            return false;
        return getId() == pet.getId() && getAge() == pet.getAge() && getSpecie() == pet.getSpecie() &&
                Objects.equals(getDescription(), pet.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSpecie(), getAge(), getDescription());
    }

}
