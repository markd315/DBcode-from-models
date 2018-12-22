package io.swagger.service;

import io.swagger.model.Pet;

import java.util.Collection;

public interface ResourceService {
    void savePet(Pet pet);
    Pet findPetById(int id);
    //Update same as save
    void deletePet(Pet pet);
    Collection<Pet> findAllPets();
}
