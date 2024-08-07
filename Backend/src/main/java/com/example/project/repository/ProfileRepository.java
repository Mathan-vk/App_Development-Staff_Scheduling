package com.example.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    // Custom query methods (if needed) can be defined here
}
