package com.kotaroito.workoutmanagerbackend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.kotaroito.workoutmanagerbackend.model.User;
import com.kotaroito.workoutmanagerbackend.service.UserService;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String saveUserAndNotify() {

        User newUser = new User("James", 170, 65);
        userService.createUser(newUser);

        return "saved user";
    }
    
}