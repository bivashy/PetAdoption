package com.bivashy.learn.pet.service;

import com.bivashy.learn.pet.entity.Pet;
import com.bivashy.learn.pet.entity.Shelter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ShelterService {

    private final List<Shelter> shelters = new ArrayList<>();
    private int idCounter = 0;

    public Shelter createShelter(String name) {
        Shelter shelter = new Shelter(idCounter++, name, new ArrayList<>());
        shelters.add(shelter);
        return shelter;
    }

    public List<Shelter> getShelters() {
        return Collections.unmodifiableList(shelters);
    }

    public Optional<Shelter> findPetShelter(Pet pet) {
        return shelters.stream()
                .filter(shelter -> shelter.getPets().contains(pet))
                .findFirst();
    }

    public Optional<Shelter> findShelterById(int shelterId) {
        return shelters.stream()
                .filter(shelter -> shelter.getId() == shelterId)
                .findFirst();
    }

}
