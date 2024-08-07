package com.example.project.repository;

import com.example.project.model.StaffScheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StaffRepo extends JpaRepository<StaffScheduling, Integer> {

    @Modifying
    @Query("select h from StaffScheduling h")
    List<StaffScheduling> getall();
}
