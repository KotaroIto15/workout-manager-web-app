package com.kotaroito.workoutmanagerbackend.exception;

public class IncorrectPasswordException extends Exception {

    public IncorrectPasswordException(String message) {
        super(message);
    }
}