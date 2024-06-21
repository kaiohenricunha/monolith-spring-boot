package com.example.monolithspringboot.controller;

import com.example.monolithspringboot.entity.MaterialDidatico;
import com.example.monolithspringboot.service.MaterialDidaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materials")
public class MaterialDidaticoController {

    @Autowired
    private MaterialDidaticoService service;

    @GetMapping
    public List<MaterialDidatico> getAllMaterials() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDidatico> getMaterialById(@PathVariable String id) {
        Optional<MaterialDidatico> material = service.findById(id);
        return material.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MaterialDidatico createMaterial(@RequestBody MaterialDidatico material) {
        return service.save(material);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialDidatico> updateMaterial(@PathVariable String id, @RequestBody MaterialDidatico updatedMaterial) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        updatedMaterial.setId(id);
        return ResponseEntity.ok(service.save(updatedMaterial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable String id) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
