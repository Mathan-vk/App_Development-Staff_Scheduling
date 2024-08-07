package com.example.project.repository;

import com.example.project.model.Login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    // Additional query methods (if any) can be defined here

    // Example: Find a Login by username
    Optional<Login> findByUsername(String username);
}
