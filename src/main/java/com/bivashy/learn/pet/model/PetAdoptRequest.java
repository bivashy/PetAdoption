package com.bivashy.learn.pet.model;

public class PetAdoptRequest {
    private final int petId;
    private final String adopterName;

    public PetAdoptRequest(int petId, String adopterName) {
        this.petId = petId;
        this.adopterName = adopterName;
    }

    public int getPetId() {
        return petId;
    }

    public String getAdopterName() {
        return adopterName;
    }

}
