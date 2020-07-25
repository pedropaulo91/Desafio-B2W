package com.example.desafiob2w.repository;
import com.example.desafiob2w.model.Planeta;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface PlanetaRepository extends MongoRepository<Planeta, ObjectId> {
    Optional<Planeta> findByNomeIgnoreCase(String nome);
}
