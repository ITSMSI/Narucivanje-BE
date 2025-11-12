// src/main/java/com/example/prototip/repositories/IRoleRepository.java
package com.example.prototip.repositories;

import com.example.prototip.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IRoleRepository extends JpaRepository<Role, UUID> {
}