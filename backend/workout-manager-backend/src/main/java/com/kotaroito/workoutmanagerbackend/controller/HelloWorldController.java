package com.kotaroito.workoutmanagerbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/sayhello")
    public String sayHello() {
        return "Hello World!!!";
    }
}