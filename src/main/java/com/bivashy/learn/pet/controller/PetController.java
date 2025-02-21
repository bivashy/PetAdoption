package com.bivashy.learn.pet.controller;

import com.bivashy.learn.pet.entity.Pet;
import com.bivashy.learn.pet.entity.Shelter;
import com.bivashy.learn.pet.entity.Specie;
import com.bivashy.learn.pet.model.PetCreateRequest;
import com.bivashy.learn.pet.service.PetService;
import com.bivashy.learn.pet.service.ShelterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PetController {

    private final PetService petService;
    private final ShelterService shelterService;

    public PetController(PetService petService, ShelterService shelterService) {
        this.petService = petService;
        this.shelterService = shelterService;
    }

    @GetMapping("/api/pets")
    public List<Pet> pets() {
        return petService.getPets();
    }

    @PostMapping("/api/registerPet")
    public ResponseEntity<Pet> registerPet(@RequestBody PetCreateRequest createRequest) {
        Optional<Shelter> foundShelter = shelterService.findShelterById(createRequest.getShelterId());
        if (foundShelter.isEmpty())
            return ResponseEntity.of(ProblemDetail.forStatusAndDetail(
                            HttpStatus.NOT_FOUND,
                            "Shelter not found"))
                    .build();
        Shelter shelter = foundShelter.get();
        return ResponseEntity.ok(petService.registerPet(shelter, createRequest.getSpecie(), createRequest.getAge(), createRequest.getDescription()));
    }

}
