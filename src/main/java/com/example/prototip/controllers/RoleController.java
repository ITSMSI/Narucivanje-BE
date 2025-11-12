// src/main/java/com/example/prototip/controllers/RoleController.java
package com.example.prototip.controllers;

import com.example.prototip.models.role.RoleModel;
import com.example.prototip.services.role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/get/all")
    public ResponseEntity<List<RoleModel>> getAllRole() {
        return ResponseEntity.ok(roleService.getAllRole());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleModel> getRole(@PathVariable UUID id) {
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @PostMapping
    public ResponseEntity<RoleModel> createRole(@RequestBody RoleModel model) {
        return ResponseEntity.ok(roleService.createRole(model));
    }
}