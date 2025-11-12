// src/main/java/com/example/prototip/repositories/IObrokRepository.java
package com.example.prototip.repositories;

import com.example.prototip.entities.Obrok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IObrokRepository extends JpaRepository<Obrok, UUID> {
}