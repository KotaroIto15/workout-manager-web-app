package com.kotaroito.workoutmanagerbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "workout")
public class Workout {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long workoutId;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    private String workoutName;
    private int rep;
    private int set;
    private int rest;

    //constructor
    public Workout(String name, int rep, int set, int rest) {
        this.workoutName = name;
        this.rep = rep;
        this.set = set;
        this.rest = rest;
    }

    public Workout() {};

    //getters
    public long getWorkoutId() { return this.workoutId; }
    public String getWorkoutName() { return this.workoutName; }
    public int getRep() { return this.rep; }
    public int getSet() { return this.set; }
    public int getRest() { return this.rest; }

    //setters
    public void setWorkoutId(long workoutId) { this.workoutId = workoutId;}
    public void setWorkoutName(String workoutName) { this.workoutName = workoutName; }
    public void setRep(int rep) { this.rep = rep; }
    public void setSet(int set) { this.set = set; }
    public void setRest(int rest) { this.rest = rest; }


}
