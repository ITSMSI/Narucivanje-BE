// src/main/java/com/example/prototip/controllers/AuthController.java
package com.example.prototip.controllers;

import com.example.prototip.entities.User;
import com.example.prototip.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        try {
            String email = credentials.get("email");
            String password = credentials.get("password");

            if (email == null || password == null || email.isBlank() || password.isBlank()) {
                return ResponseEntity.badRequest().body(Map.of("error", "Email and password are required"));
            }

            User user = userService.findByEmail(email);
            if (user == null) {
                return ResponseEntity.status(401).body(Map.of("error", "User not found"));
            }

            if (!passwordEncoder.matches(password, user.getPassword())) {
                return ResponseEntity.status(401).body(Map.of("error", "Invalid password"));
            }

            return ResponseEntity.ok(Map.of(
                "token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI" + user.getId().toString().replace("-", "") + 
                         "IiwibmFtZSI6IkRhdm9yIERpbWVza2kiLCJlbWFpbCI6ImRhdm9yQGRpbWVza2kuY29tIiwiaWF0IjoxNzM2NzA0MDAwfQ.dummy-signature-for-testing-only",
                "message", "Login successful",
                "userId", user.getId().toString(),
                "email", user.getEmail(),
                "name", (user.getIme() != null ? user.getIme() : "") + " " + (user.getPrezime() != null ? user.getPrezime() : "")
            ));

        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Internal server error: " + e.getMessage()));
        }
    }
}