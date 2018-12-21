package io.swagger.service;

import io.swagger.model.Pet;

import java.util.Collection;

public interface ResourceService {
    Pet findPetById(int id);
    Collection<Pet> findAllPets();
    void savePet(Pet pet);
    void deletePet(Pet pet);
}
