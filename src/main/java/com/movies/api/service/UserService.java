package com.movies.api.service;

import com.movies.api.exceptions.NotFoundException;
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

    public User updateUser(Long userId, User updatedUser) {
        // Retrieve the existing user from the database
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            // Update the existing user with the new data
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            // Update other fields as needed

            // Save the updated user back to the database
            return userRepository.save(existingUser);
        } else {
            // If the user with the specified ID doesn't exist, you can throw an exception
            throw new NotFoundException("User not found with id: " + userId);
        }
    }
}
