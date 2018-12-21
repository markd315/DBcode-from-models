package io.swagger.repository;

import io.swagger.model.Pet;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//@Profile("spring-data-jpa")
public interface PetRepository extends MongoRepository<Pet, Integer> {
    List<Pet> findAll() throws DataAccessException;

    Pet findById(int id) throws DataAccessException;

    Pet save(Pet pet) throws DataAccessException;

    void delete(Pet pet) throws DataAccessException;
}
