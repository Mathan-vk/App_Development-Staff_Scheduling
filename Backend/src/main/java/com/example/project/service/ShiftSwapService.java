package com.example.project.service;

import com.example.project.model.ShiftSwap;

import com.example.project.repository.ShiftswapRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShiftSwapService {

    @Autowired
    private ShiftswapRepository shiftSwapRepository;

    // Save a new shift swap
    public ShiftSwap saveShiftSwap(ShiftSwap shiftSwap) {
        return shiftSwapRepository.save(shiftSwap);
    }

    // Retrieve all shift swaps
    public List<ShiftSwap> getAllShiftSwaps() {
        return shiftSwapRepository.findAll();
    }

    // Retrieve a shift swap by ID
    public Optional<ShiftSwap> getShiftSwapById(Long id) {
        return shiftSwapRepository.findById(id);
    }

    // Update an existing shift swap
    public Optional<ShiftSwap> updateShiftSwap(Long id, ShiftSwap shiftSwapDetails) {
        return shiftSwapRepository.findById(id)
            .map(existingShiftSwap -> {
                existingShiftSwap.setStartTime(shiftSwapDetails.getStartTime());
                existingShiftSwap.setEndTime(shiftSwapDetails.getEndTime());
                existingShiftSwap.setShiftStatus(shiftSwapDetails.getShiftStatus());
                existingShiftSwap.setDate(shiftSwapDetails.getDate());
                existingShiftSwap.setStaffId(shiftSwapDetails.getStaffId());
                return shiftSwapRepository.save(existingShiftSwap);
            });
    }

    // Delete a shift swap
    public boolean deleteShiftSwap(Long id) {
        if (shiftSwapRepository.existsById(id)) {
            shiftSwapRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

