package dev.cfan.rocklifterapi.service;

import dev.cfan.rocklifterapi.model.User;
import dev.cfan.rocklifterapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserByName(String username) {
        return userRepository.findByName(username);
    }

    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }
}
