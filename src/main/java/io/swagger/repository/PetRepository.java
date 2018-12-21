package io.swagger.repository;

import io.swagger.model.Pet;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import java.util.Collection;

@Profile("spring-data-jpa")
public interface PetRepository extends Repository<Pet, Integer> {
    Collection<Pet> findAll() throws DataAccessException;

    Pet findById(int id) throws DataAccessException;

    void save(Pet pet) throws DataAccessException;

    void delete(Pet pet) throws DataAccessException;
}
