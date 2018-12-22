package io.swagger.repository;

import io.swagger.model.Category;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, Integer> {
    List<Category> findAll() throws DataAccessException;

    Category findById(int id) throws DataAccessException;

    Category save(Category category) throws DataAccessException;

    void delete(Category category) throws DataAccessException;
}
