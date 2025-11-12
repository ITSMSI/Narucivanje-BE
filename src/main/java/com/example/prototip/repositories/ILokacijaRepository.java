// src/main/java/com/example/prototip/repositories/ILokacijaRepository.java
package com.example.prototip.repositories;

import com.example.prototip.entities.Lokacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ILokacijaRepository extends JpaRepository<Lokacija, UUID> {
}