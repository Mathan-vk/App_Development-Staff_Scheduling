package com.example.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.StaffScheduling;
import com.example.project.service.StaffSchedulingService;

@RestController
@RequestMapping("/api")
public class Staffcontroller {

    @Autowired
    private StaffSchedulingService ps;
    @PostMapping("/staff")
    public ResponseEntity<StaffScheduling> createStaff(@RequestBody StaffScheduling staff) {
        StaffScheduling createdStaff = ps.createPatient(staff);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStaff);
    }
    @GetMapping("/staffs")
    public List<StaffScheduling> getAllStaff() {
        return ps.getall();
    }

    @GetMapping("/staff/{staffId}")
    public ResponseEntity<StaffScheduling> getStaffById(@PathVariable int staffId) {
        Optional<StaffScheduling> staff = ps.getPatientById(staffId);
        return staff.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/staff/{staffId}")
    public ResponseEntity<StaffScheduling> updateStaff(@PathVariable("staffId") int staffId,
            @RequestBody StaffScheduling staff) {
        boolean updated = ps.updateDetails(staffId, staff);
        return updated ? ResponseEntity.ok(staff) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/staff/{staffId}")
    public ResponseEntity<Boolean> deleteStaff(@PathVariable("staffId") int staffId) {
        boolean deleted = ps.deleteStudent(staffId);
        return deleted ? ResponseEntity.ok(true) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }
}
