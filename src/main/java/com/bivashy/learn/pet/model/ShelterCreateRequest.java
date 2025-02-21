package com.bivashy.learn.pet.model;

public class ShelterCreateRequest {
    private final String name;

    public ShelterCreateRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
