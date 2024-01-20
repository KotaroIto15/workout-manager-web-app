package com.kotaroito.workoutmanagerbackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kotaroito.workoutmanagerbackend.repository.UserRepository;
import com.kotaroito.workoutmanagerbackend.service.UserService;
import com.kotaroito.workoutmanagerbackend.exception.UserNotFoundException;
import com.kotaroito.workoutmanagerbackend.model.User;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long userId, User user) {

        if (userRepository.existsById(userId)) {
            user.setId(userId);
            return userRepository.save(user);
        }

        return null;
    }

    public String userExists(String email) throws UserNotFoundException {

        if (userRepository.existsByEmail(email)) {
            return userRepository.findByEmail(email).getPassword();
        } else {
            throw new UserNotFoundException("User not found");
		}
    }

}