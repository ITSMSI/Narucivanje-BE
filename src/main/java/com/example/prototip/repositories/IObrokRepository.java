package com.example.prototip.repositories;

import com.example.prototip.entities.Obrok;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IObrokRepository extends JpaRepository<Obrok,Long> {
    Obrok findByNaziv(String naziv);
}
