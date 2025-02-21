package com.bivashy.learn.pet.controller;

import com.bivashy.learn.pet.entity.Shelter;
import com.bivashy.learn.pet.model.ShelterCreateRequest;
import com.bivashy.learn.pet.service.ShelterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShelterController {

    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @GetMapping("/api/shelters")
    public List<Shelter> shelters() {
        return shelterService.getShelters();
    }

    @PostMapping("/api/createShelter")
    public ResponseEntity<Shelter> createShelter(@RequestBody ShelterCreateRequest createRequest) {
        return ResponseEntity.ok(shelterService.createShelter(createRequest.getName()));
    }

}
