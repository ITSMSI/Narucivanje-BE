package com.example.prototip.repositories;

import com.example.prototip.entities.Kompanija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKompanijaRepository extends JpaRepository<Kompanija,Long> {
    Kompanija findByNaziv(String naziv);
}
