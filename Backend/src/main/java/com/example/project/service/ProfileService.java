package com.example.project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.Profile;
import com.example.project.repository.ProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    // Save a new profile
    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    // Retrieve all profiles
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    // Retrieve a profile by ID
    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    // Update an existing profile
    public Optional<Profile> updateProfile(Long id, Profile profileDetails) {
        if (profileRepository.existsById(id)) {
            profileDetails.setProfileId(id);
            return Optional.of(profileRepository.save(profileDetails));
        }
        return Optional.empty();
    }

    // Delete a profile
    public boolean deleteProfile(Long id) {
        if (profileRepository.existsById(id)) {
            profileRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
