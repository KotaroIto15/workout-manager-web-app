package com.kotaroito.workoutmanagerbackend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.kotaroito.workoutmanagerbackend.model.User;
import com.kotaroito.workoutmanagerbackend.service.impl.UserServiceImpl;


@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/user")
    public String saveUserAndNotify() {

        User newUser = new User("Sample", "Name", "sample@gmail.com", 174, 70, "password");
        userService.createUser(newUser);

        return "saved user";
    }
    
}