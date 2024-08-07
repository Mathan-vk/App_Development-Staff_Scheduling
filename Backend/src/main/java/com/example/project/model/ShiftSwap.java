package com.example.project.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "shift_swap")
public class ShiftSwap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shiftswapId;

    private LocalTime startTime;
    private LocalTime endTime;
    private String shiftStatus;
    private LocalDate date;
    private Long staffId;

    // Constructors
    public ShiftSwap() {}

    public ShiftSwap(Long shiftswapId, LocalTime startTime, LocalTime endTime, String shiftStatus, LocalDate date, Long staffId) {
        this.shiftswapId = shiftswapId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shiftStatus = shiftStatus;
        this.date = date;
        this.staffId = staffId;
    }

    // Getters and Setters
    public Long getShiftswapId() {
        return shiftswapId;
    }

    public void setShiftswapId(Long shiftswapId) {
        this.shiftswapId = shiftswapId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getShiftStatus() {
        return shiftStatus;
    }

    public void setShiftStatus(String shiftStatus) {
        this.shiftStatus = shiftStatus;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
}
