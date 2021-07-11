package com.prueba.laboral.repositorios;

import com.prueba.laboral.models.LibroModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepo extends MongoRepository<LibroModel, String> {

}
