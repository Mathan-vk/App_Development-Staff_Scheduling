package com.example.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.TimeofRequest;

@Repository
public interface TimeofRequestRepository extends JpaRepository<TimeofRequest, Long> {
    // Custom query methods (if needed) can be defined here
}

