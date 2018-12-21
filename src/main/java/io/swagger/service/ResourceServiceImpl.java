package io.swagger.service;

import io.swagger.model.Pet;
import io.swagger.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ResourceServiceImpl implements ResourceService {
    private PetRepository petRepository;

    @Autowired
    public ResourceServiceImpl(
            PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findPetById(int id) throws DataAccessException {
        Pet pet= petRepository.findById(id);
        return pet;
    }

    @Override
    public Collection<Pet> findAllPets() throws DataAccessException {
        return petRepository.findAll();
    }

    @Override
    public void savePet(Pet pet) throws DataAccessException {
        petRepository.save(pet);
    }

    @Override
    public void deletePet(Pet pet) throws DataAccessException {
        petRepository.delete(pet);
    }
}
