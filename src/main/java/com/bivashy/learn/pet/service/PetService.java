package com.bivashy.learn.pet.service;

import com.bivashy.learn.pet.entity.Pet;
import com.bivashy.learn.pet.entity.Shelter;
import com.bivashy.learn.pet.entity.Specie;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetService {

    private final ShelterService shelterService;
    private int idCounter = 0;

    public PetService(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    public Pet registerPet(Shelter shelter, Specie specie, int age, String description) {
        Pet pet = new Pet(idCounter++, specie, age, description);
        shelter.addPet(pet);
        return pet;
    }

    public Optional<Pet> findPetById(int id) {
        return shelterService.getShelters().stream()
                .map(Shelter::getPets)
                .flatMap(Collection::stream)
                .filter(pet -> pet.getId() == id)
                .findFirst();
    }

    public List<Pet> getPets() {
        return shelterService.getShelters()
                .stream()
                .map(Shelter::getPets)
                .flatMap(Collection::stream)
                .toList();
    }

}
