// src/main/java/com/example/prototip/repositories/UserRepository.java
package com.example.prototip.repositories;

import com.example.prototip.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}