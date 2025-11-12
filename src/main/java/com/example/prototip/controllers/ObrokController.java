// src/main/java/com/example/prototip/controllers/ObrokController.java
package com.example.prototip.controllers;

import com.example.prototip.models.obrok.ObrokModel;
import com.example.prototip.services.obrok.ObrokService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/obrok")
@RequiredArgsConstructor
public class ObrokController {

    private final ObrokService obrokService;

    @GetMapping("/get/all")
    public ResponseEntity<List<ObrokModel>> getAllObrok() {
        return ResponseEntity.ok(obrokService.getAllObrok());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObrokModel> getObrok(@PathVariable UUID id) {
        return ResponseEntity.ok(obrokService.getObrokById(id));
    }

    @PostMapping
    public ResponseEntity<ObrokModel> createObrok(@RequestBody ObrokModel model) {
        return ResponseEntity.ok(obrokService.createObrok(model));
    }
}