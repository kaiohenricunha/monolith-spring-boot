package com.example.monolithspringboot.repository;

import com.example.monolithspringboot.entity.MaterialDidatico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaterialDidaticoRepository extends MongoRepository<MaterialDidatico, String> {
}
