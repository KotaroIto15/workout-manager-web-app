package com.kotaroito.workoutmanagerbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int height;
    private int weight;

    public User(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public User(String name) {
        this.name = name;
    }
    
    // getters
    public String getName() { return this.name; }
    public int getHeight() { return this.height; }
    public int getWeight() { return this.weight; }

    //setters
    public void setName(String name) { this.name = name; }
    public void setHeight(int height) { this.height = height; }
    public void setWeight(int weight) { this.weight = weight; }
}