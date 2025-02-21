package com.bivashy.learn.pet.controller;

import com.bivashy.learn.pet.entity.Adopter;
import com.bivashy.learn.pet.entity.Pet;
import com.bivashy.learn.pet.entity.Shelter;
import com.bivashy.learn.pet.model.PetAdoptRequest;
import com.bivashy.learn.pet.service.AdopterService;
import com.bivashy.learn.pet.service.PetService;
import com.bivashy.learn.pet.service.ShelterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AdoptController {

    private final ShelterService shelterService;
    private final PetService petService;
    private final AdopterService adopterService;

    public AdoptController(ShelterService shelterService, PetService petService, AdopterService adopterService) {
        this.shelterService = shelterService;
        this.petService = petService;
        this.adopterService = adopterService;
    }

    @GetMapping("/adopters")
    public List<Adopter> adopters() {
        return adopterService.getAdopters();
    }

    @PostMapping("/adopt")
    public ResponseEntity<Adopter> adopt(@RequestBody PetAdoptRequest adoptRequest) {
        Optional<Pet> foundPet = petService.findPetById(adoptRequest.getPetId());
        if (foundPet.isEmpty())
            return ResponseEntity.of(ProblemDetail.forStatusAndDetail(
                            HttpStatus.NOT_FOUND,
                            "Pet with id %d not found".formatted(adoptRequest.getPetId())))
                    .build();
        Pet pet = foundPet.get();
        Optional<Shelter> foundShelter = shelterService.findPetShelter(pet);
        if (foundShelter.isEmpty())
            return ResponseEntity.of(ProblemDetail.forStatusAndDetail(
                            HttpStatus.NOT_FOUND,
                            "Shelter of the pet not found"))
                    .build();
        Adopter adopter = adopterService.createAdopter(adoptRequest.getAdopterName(), pet);
        Shelter shelter = foundShelter.get();
        shelter.removePet(pet);
        return ResponseEntity.ok(adopter);
    }

}
