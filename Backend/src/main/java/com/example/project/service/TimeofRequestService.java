package com.example.project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.TimeofRequest;
import com.example.project.repository.TimeofRequestRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TimeofRequestService {

    @Autowired
    private TimeofRequestRepository timeOfRequestRepository;

    // Save a new time off request
    public TimeofRequest saveTimeOfRequest(TimeofRequest timeOfRequest) {
        return timeOfRequestRepository.save(timeOfRequest);
    }

    // Retrieve all time off requests
    public List<TimeofRequest> getAllTimeOfRequests() {
        return timeOfRequestRepository.findAll();
    }

    // Retrieve a time off request by ID
    public Optional<TimeofRequest> getTimeOfRequestById(Long id) {
        return timeOfRequestRepository.findById(id);
    }

    // Update an existing time off request
    public Optional<TimeofRequest> updateTimeOfRequest(Long id, TimeofRequest timeOfRequestDetails) {
        if (timeOfRequestRepository.existsById(id)) {
            timeOfRequestDetails.setTimeRequestId(id);
            return Optional.of(timeOfRequestRepository.save(timeOfRequestDetails));
        }
        return Optional.empty();
    }

    // Delete a time off request
    public boolean deleteTimeOfRequest(Long id) {
        if (timeOfRequestRepository.existsById(id)) {
            timeOfRequestRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
