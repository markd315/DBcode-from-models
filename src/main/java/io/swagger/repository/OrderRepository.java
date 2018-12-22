package io.swagger.repository;

import io.swagger.model.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, Integer> {
    List<Order> findAll() throws DataAccessException;

    Order findById(int id) throws DataAccessException;

    Order save(Order order) throws DataAccessException;

    void delete(Order order) throws DataAccessException;
}
