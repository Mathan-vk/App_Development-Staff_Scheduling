package com.example.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.project.model.ShiftSwap;
import com.example.project.service.ShiftSwapService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shift-swaps")
public class ShiftSwapController {

    @Autowired
    private ShiftSwapService shiftSwapService;

    // Create a new shift swap
    @PostMapping
    public ResponseEntity<ShiftSwap> createShiftSwap(@RequestBody ShiftSwap shiftSwap) {
        ShiftSwap createdShiftSwap = shiftSwapService.saveShiftSwap(shiftSwap);
        return new ResponseEntity<>(createdShiftSwap, HttpStatus.CREATED);
    }

    // Get all shift swaps
    @GetMapping
    public ResponseEntity<List<ShiftSwap>> getAllShiftSwaps() {
        List<ShiftSwap> shiftSwaps = shiftSwapService.getAllShiftSwaps();
        return new ResponseEntity<>(shiftSwaps, HttpStatus.OK);
    }

    // Get a shift swap by ID
    @GetMapping("/{id}")
    public ResponseEntity<ShiftSwap> getShiftSwapById(@PathVariable Long id) {
        Optional<ShiftSwap> shiftSwap = shiftSwapService.getShiftSwapById(id);
        return shiftSwap.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a shift swap
    @PutMapping("/{id}")
    public ResponseEntity<ShiftSwap> updateShiftSwap(@PathVariable Long id, @RequestBody ShiftSwap shiftSwapDetails) {
        Optional<ShiftSwap> updatedShiftSwap = shiftSwapService.updateShiftSwap(id, shiftSwapDetails);
        return updatedShiftSwap.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                               .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete a shift swap
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShiftSwap(@PathVariable Long id) {
        boolean isDeleted = shiftSwapService.deleteShiftSwap(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
