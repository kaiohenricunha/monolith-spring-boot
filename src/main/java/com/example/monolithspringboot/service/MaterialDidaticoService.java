package com.example.monolithspringboot.service;

import com.example.monolithspringboot.entity.MaterialDidatico;
import com.example.monolithspringboot.repository.MaterialDidaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialDidaticoService {

    @Autowired
    private MaterialDidaticoRepository repository;

    public List<MaterialDidatico> findAll() {
        return repository.findAll();
    }

    public Optional<MaterialDidatico> findById(String id) {
        return repository.findById(id);
    }

    public MaterialDidatico save(MaterialDidatico material) {
        return repository.save(material);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
