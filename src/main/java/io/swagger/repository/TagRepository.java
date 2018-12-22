package io.swagger.repository;

import io.swagger.model.Tag;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TagRepository extends MongoRepository<Tag, Integer> {
    List<Tag> findAll() throws DataAccessException;

    Tag findById(int id) throws DataAccessException;

    Tag save(Tag tag) throws DataAccessException;

    void delete(Tag tag) throws DataAccessException;
}
