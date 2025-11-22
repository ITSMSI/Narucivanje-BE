// src/main/java/com/example/prototip/repositories/IMeniRepository.java

package com.example.prototip.repositories;

import com.example.prototip.entities.Meni;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IMeniRepository extends JpaRepository<Meni, UUID> {
    // REMOVE THIS METHOD COMPLETELY – there is no "datum" field!
    // Meni com.example.prototip.repositories.IMeniRepository.findByDatum(java.sql.Date);
}