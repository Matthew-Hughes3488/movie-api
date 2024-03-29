package com.movies.api.service;

import com.movies.api.models.User;
import com.movies.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Method to get a user by ID
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    // Method to save a user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Method to delete a user by ID
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    // You can define other methods here to interact with the repository as needed
}
