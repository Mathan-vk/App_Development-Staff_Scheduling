package com.example.project.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Login {

    @Id
    private int userId;
    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "profileId")
    private Profile profile;

    // No-argument constructor
    public Login() {}

    // Parameterized constructor
    public Login(int userId, String username, String password, Profile profile) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
