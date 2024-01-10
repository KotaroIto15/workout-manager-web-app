package com.kotaroito.workoutmanagerbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        initialValue = 1,
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence")
    private long userId;

    @Column(
        name = "name",
        updatable = true,
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String name;

    @Column(
        name = "height",
        updatable = true,
        nullable = false
    )
    private int height;

    @Column(
        name = "weight",
        updatable = true,
        nullable = false
    )
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
    public long getId() { return this.userId; }
    public String getName() { return this.name; }
    public int getHeight() { return this.height; }
    public int getWeight() { return this.weight; }

    //setters
    public void setId(Long id) { this.userId = id; }
    public void setName(String name) { this.name = name; }
    public void setHeight(int height) { this.height = height; }
    public void setWeight(int weight) { this.weight = weight; }
}