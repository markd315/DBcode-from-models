package io.swagger.repository;

import io.swagger.model.ModelApiResponse;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ModelApiResponseRepository extends MongoRepository<ModelApiResponse, Integer> {
    List<ModelApiResponse> findAll() throws DataAccessException;

    ModelApiResponse findById(int id) throws DataAccessException;

    ModelApiResponse save(ModelApiResponse modelapiresponse) throws DataAccessException;

    void delete(ModelApiResponse modelapiresponse) throws DataAccessException;
}
