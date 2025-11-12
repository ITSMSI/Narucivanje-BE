package com.example.prototip.repositories;

import com.example.prototip.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);


}
