package com.kotaroito.workoutmanagerbackend.service;

import java.util.List;
import java.util.Optional;

import com.kotaroito.workoutmanagerbackend.exception.UserNotFoundException;
import com.kotaroito.workoutmanagerbackend.model.User;

public interface UserService {

    public List<User> getAllUsers();
    public Optional<User> getUserById(Long id);
    public User createUser(User user);
    public void deleteUser(Long id);
    public User updateUser(Long userId, User user);
    public String userExists(String email) throws UserNotFoundException;
}