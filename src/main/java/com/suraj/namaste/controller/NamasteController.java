package com.suraj.namaste.controller;


import com.suraj.namaste.entity.NamasteEntity;
import com.suraj.namaste.service.NamasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/namaste")
public class NamasteController {

    private final NamasteService namasteService;

    @Autowired
    public NamasteController(NamasteService namasteService) {
        this.namasteService = namasteService;
    }

    // GET all namastes
    @GetMapping
    public ResponseEntity<List<NamasteEntity>> getAllNamastes() {
        List<NamasteEntity> namastes = namasteService.getAllNamastes();
        return ResponseEntity.ok(namastes);
    }

    // GET a single namaste by ID
    @GetMapping("/{id}")
    public ResponseEntity<NamasteEntity> getNamasteById(@PathVariable Long id) {
        Optional<NamasteEntity> namaste = namasteService.getNamasteById(id);
        return namaste.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CREATE a new namaste
    @PostMapping
    public ResponseEntity<NamasteEntity> createNamaste(@RequestBody NamasteEntity namasteEntity) {
        NamasteEntity createdNamaste = namasteService.createNamaste(namasteEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNamaste);
    }

    // UPDATE an existing namaste
    @PutMapping("/{id}")
    public ResponseEntity<NamasteEntity> updateNamaste(@PathVariable Long id, @RequestBody NamasteEntity namasteEntity) {
        Optional<NamasteEntity> updatedNamaste = namasteService.updateNamaste(id, namasteEntity);
        return updatedNamaste.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE a namaste
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNamaste(@PathVariable Long id) {
        boolean deleted = namasteService.deleteNamaste(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}