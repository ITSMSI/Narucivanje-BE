package com.example.prototip.repositories;

import com.example.prototip.entities.Lokacija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILokacijaRepository extends JpaRepository<Lokacija,Long> {
    Lokacija findByAdresa(String adresa);
}
