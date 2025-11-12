// src/main/java/com/example/prototip/repositories/UserRepository.java
package com.example.prototip.repositories;

import com.example.prototip.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}