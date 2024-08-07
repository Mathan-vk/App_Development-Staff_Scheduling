package com.example.project.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "time_of_request")
public class TimeofRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeRequestId;

    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveType;
    private String reason;
    private LocalDate requestDate;
    private String status;
    private Long staffId;

    // Constructors
    public TimeofRequest() {}

    public TimeofRequest(Long timeRequestId, LocalDate startDate, LocalDate endDate, String leaveType, String reason, LocalDate requestDate, String status, Long staffId) {
        this.timeRequestId = timeRequestId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.reason = reason;
        this.requestDate = requestDate;
        this.status = status;
        this.staffId = staffId;
    }

    // Getters and Setters
    public Long getTimeRequestId() {
        return timeRequestId;
    }

    public void setTimeRequestId(Long timeRequestId) {
        this.timeRequestId = timeRequestId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
}
