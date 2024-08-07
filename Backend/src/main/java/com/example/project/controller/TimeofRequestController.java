package com.example.project.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.project.model.TimeofRequest;
import com.example.project.service.TimeofRequestService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/time-of-requests")
public class TimeofRequestController {

    @Autowired
    private TimeofRequestService timeofRequestService;

    // Create a new time off request
    @PostMapping
    public ResponseEntity<TimeofRequest> createTimeOfRequest(@RequestBody TimeofRequest timeOfRequest) {
        TimeofRequest createdTimeOfRequest = timeofRequestService.saveTimeOfRequest(timeOfRequest);
        return new ResponseEntity<>(createdTimeOfRequest, HttpStatus.CREATED);
    }

    // Get all time off requests
    @GetMapping
    public ResponseEntity<List<TimeofRequest>> getAllTimeOfRequests() {
        List<TimeofRequest> timeOfRequests = timeofRequestService.getAllTimeOfRequests();
        return new ResponseEntity<>(timeOfRequests, HttpStatus.OK);
    }

    // Get a time off request by ID
    @GetMapping("/{id}")
    public ResponseEntity<TimeofRequest> getTimeOfRequestById(@PathVariable Long id) {
        Optional<TimeofRequest> timeOfRequest = timeofRequestService.getTimeOfRequestById(id);
        return timeOfRequest.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a time off request
   // Update a time off request
@PutMapping("/{id}")
public ResponseEntity<TimeofRequest> updateTimeOfRequest(@PathVariable Long id, @RequestBody TimeofRequest timeOfRequestDetails) {
    Optional<TimeofRequest> updatedTimeOfRequest = timeofRequestService.updateTimeOfRequest(id, timeOfRequestDetails);
    return updatedTimeOfRequest.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                               .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
}


    // Delete a time off request
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimeOfRequest(@PathVariable Long id) {
        boolean isDeleted = timeofRequestService.deleteTimeOfRequest(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
