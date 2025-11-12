// src/main/java/com/example/prototip/controllers/KompanijaController.java
package com.example.prototip.controllers;

import com.example.prototip.models.kompanija.KompanijaModel;
import com.example.prototip.services.kompanija.KompanijaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/kompanija")
@RequiredArgsConstructor
public class KompanijaController {

    private final KompanijaService kompanijaService;

    @GetMapping("/{id}")
    public ResponseEntity<KompanijaModel> getKompanija(@PathVariable UUID id) {
        return ResponseEntity.ok(kompanijaService.getKompanijaById(id));
    }

    @PostMapping
    public ResponseEntity<KompanijaModel> createKompanija(@RequestBody KompanijaModel model) {
        return ResponseEntity.ok(kompanijaService.createKompanija(model));
    }
}