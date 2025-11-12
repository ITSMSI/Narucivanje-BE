// src/main/java/com/example/prototip/repositories/IKompanijaRepository.java
package com.example.prototip.repositories;

import com.example.prototip.entities.Kompanija;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IKompanijaRepository extends JpaRepository<Kompanija, UUID> {
}