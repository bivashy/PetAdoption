package com.bivashy.learn.pet.service;

import com.bivashy.learn.pet.entity.Shelter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ShelterService {

    private final List<Shelter> shelters = new ArrayList<>();
    private int idCounter = 0;

    public void createShelter(String name) {
        shelters.add(new Shelter(idCounter++, name, new ArrayList<>()));
    }

    public List<Shelter> getShelters() {
        return Collections.unmodifiableList(shelters);
    }

}
