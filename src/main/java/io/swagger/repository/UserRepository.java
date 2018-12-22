package io.swagger.repository;

import io.swagger.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, Integer> {
    List<User> findAll() throws DataAccessException;

    User findById(int id) throws DataAccessException;

    User save(User user) throws DataAccessException;

    void delete(User user) throws DataAccessException;
}
