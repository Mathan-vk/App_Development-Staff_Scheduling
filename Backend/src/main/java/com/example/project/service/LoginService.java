package com.example.project.service;

import com.example.project.model.Login;
import com.example.project.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Login createLogin(Login login) {
        return loginRepository.save(login);
    }

    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    public Optional<Login> getLoginById(int userId) {
        return loginRepository.findById(userId);
    }

    public boolean updateLogin(int userId, Login updatedLogin) {
        if (loginRepository.existsById(userId)) {
            updatedLogin.setUserId(userId);
            loginRepository.save(updatedLogin);
            return true;
        }
        return false;
    }

    public boolean deleteLogin(int userId) {
        if (loginRepository.existsById(userId)) {
            loginRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
