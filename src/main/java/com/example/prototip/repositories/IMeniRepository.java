package com.example.prototip.repositories;

import com.example.prototip.entities.Meni;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface IMeniRepository extends JpaRepository<Meni,Long> {
    Meni findByDatum(@NotBlank Date datum);
}
