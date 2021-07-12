package com.prueba.laboral.repositorios;

import com.prueba.laboral.models.UsersModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends MongoRepository<UsersModel, String> {

    public UsersModel findByNombre(String id);

}
