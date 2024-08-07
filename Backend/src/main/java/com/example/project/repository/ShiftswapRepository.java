package com.example.project.repository;


import com.example.project.model.ShiftSwap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftswapRepository extends JpaRepository<ShiftSwap, Long> {
    // Custom query methods (if needed) can be defined here
}

