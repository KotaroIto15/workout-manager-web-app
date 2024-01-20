package com.kotaroito.workoutmanagerbackend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kotaroito.workoutmanagerbackend.dto.LoginRequestDTO;
import com.kotaroito.workoutmanagerbackend.exception.IncorrectPasswordException;
import com.kotaroito.workoutmanagerbackend.exception.UserNotFoundException;
import com.kotaroito.workoutmanagerbackend.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LoginController{

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public String tryLogin(@RequestBody LoginRequestDTO userInfo) {

        try {
            String password = userService.userExists(userInfo.getEmail());
            if (password.equals(userInfo.getPassword())) {
                return "Login Success";
            } else {
                throw new IncorrectPasswordException("Login failed");
            }
        } catch (UserNotFoundException notFoundException) {
            return notFoundException.getMessage();
        } catch (IncorrectPasswordException incorrectPasswordException) {
            return incorrectPasswordException.getMessage();
        }

    }

}