package com.example.project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.Schedule;
import com.example.project.repository.ScheduleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    // Save a new schedule
    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // Retrieve all schedules
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    // Retrieve a schedule by ID
    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    // Update an existing schedule
    public Optional<Schedule> updateSchedule(Long id, Schedule scheduleDetails) {
        if (scheduleRepository.existsById(id)) {
            scheduleDetails.setScheduleID(id);
            return Optional.of(scheduleRepository.save(scheduleDetails));
        }
        return Optional.empty();
    }

    // Delete a schedule
    public boolean deleteSchedule(Long id) {
        if (scheduleRepository.existsById(id)) {
            scheduleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
