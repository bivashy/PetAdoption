package com.bivashy.learn.pet.service;

import com.bivashy.learn.pet.entity.Adopter;
import com.bivashy.learn.pet.entity.Pet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AdopterService {

    private final List<Adopter> adopters = new ArrayList<>();
    private int idCounter = 0;

    public Adopter createAdopter(String name, Pet adoptedPet) {
        Adopter adopter = new Adopter(idCounter++, adoptedPet, name);
        adopters.add(adopter);
        return adopter;
    }

    public List<Adopter> getAdopters() {
        return Collections.unmodifiableList(adopters);
    }

}
