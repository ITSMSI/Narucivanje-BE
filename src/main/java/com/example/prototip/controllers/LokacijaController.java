// src/main/java/com/example/prototip/controllers/LokacijaController.java
package com.example.prototip.controllers;

import com.example.prototip.models.lokacija.LokacijaModel;
import com.example.prototip.services.lokacija.LokacijaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lokacija")
@RequiredArgsConstructor
public class LokacijaController {

    private final LokacijaService lokacijaService;

    @GetMapping("/get/all")
    public ResponseEntity<List<LokacijaModel>> getAllLokacija() {
        return ResponseEntity.ok(lokacijaService.getAllLokacija());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LokacijaModel> getLokacija(@PathVariable UUID id) {
        return ResponseEntity.ok(lokacijaService.getLokacijaById(id));
    }

    @PostMapping
    public ResponseEntity<LokacijaModel> createLokacija(@RequestBody LokacijaModel model) {
        return ResponseEntity.ok(lokacijaService.createLokacija(model));
    }
}