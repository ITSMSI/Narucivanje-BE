package com.example.prototip.repositories;

import com.example.prototip.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role,Long> {
    Role findByNaziv(String naziv);
}
