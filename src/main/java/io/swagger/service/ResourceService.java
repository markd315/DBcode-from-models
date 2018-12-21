package io.swagger.service;

import io.swagger.model.Pet;
import io.swagger.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;

import java.util.Collection;

public class ResourceService {
    private PetRepository petRepository;

    @Autowired
    public ResourceService(
            PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet findPetById(int id) throws DataAccessException {
        Pet pet;
        try {
            pet = petRepository.findById(id);
        } catch (ObjectRetrievalFailureException | EmptyResultDataAccessException e) {
            // just ignore not found exceptions for Jdbc/Jpa realization
            return null;
        }
        return pet;
    }

    public Collection<Pet> findAllPets() throws DataAccessException {
        return petRepository.findAll();
    }

    public void savePet(Pet pet) throws DataAccessException {
        petRepository.save(pet);
    }

    public void deletePet(Pet pet) throws DataAccessException {
        petRepository.delete(pet);
    }
}
