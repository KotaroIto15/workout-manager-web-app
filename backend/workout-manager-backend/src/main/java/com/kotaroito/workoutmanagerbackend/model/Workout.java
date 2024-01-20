package com.kotaroito.workoutmanagerbackend.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Workouts")
public class Workout {

    @Id
    @SequenceGenerator(
        name = "workout_sequence",
        sequenceName = "workout_sequence",
        initialValue = 1,
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "workout_sequence"
    )
    private long workoutId;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Column(
        name = "name",
        updatable = true,
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String name;

    @Column(
        name = "set",
        updatable = true,
        nullable = false,
        columnDefinition = "INTEGER"
    )
    private int set;

    @Column(
        name = "rep",
        updatable = true,
        nullable = false,
        columnDefinition = "INTEGER"
    )
    private int rep;

    @Column(
        name = "rest",
        updatable = true,
        nullable = false,
        columnDefinition = "INTEGER"
    )
    private int rest;

    @Column(
        name = "weight_lb",
        updatable = true,
        nullable = false,
        columnDefinition = "INTEGER"
    )
    private int weightLB;

    @Column(
        name = "weight_kg",
        updatable = true,
        nullable = false,
        columnDefinition = "INTEGER"
    )
    private int weightKG;

    // constructor
    public Workout(Schedule schedule, String name, int set, int rep, int rest, int weightLB, int weightKG) {
        this.schedule = schedule;
        this.name = name;
        this.set = set;
        this.rep = rep;
        this.rest = rest;
        this.weightLB = weightLB;
        this.weightKG = weightKG;
    }

    // getters
    public long getWorkoutId() { return this.workoutId; }
    public Schedule getSchedule() { return this.schedule; }
    public String getName() { return this.name; }
    public int getSet() { return this.set; }
    public int getRep() { return this.rep; }
    public int getRest() { return this.rest; }
    public int getWeightLB() { return this.weightLB; }
    public int getWeightKG() { return this.weightKG; }

    // setters
    public void setSchedule(Schedule schedule) { this.schedule = schedule; }
    public void setName(String name) { this.name = name; }
    public void setSet(int set) { this.set = set; }
    public void setRep(int rep) { this.rep = rep; }
    public void setRest(int rest) { this.rest = rest; }
    public void setWeightLB(int weightLB) { 
        this.weightLB = weightLB; 
        this.weightKG = LBtoKG(weightLB);
    }
    public void setWeightKG(int weightKG) { 
        this.weightKG = weightKG; 
        this.weightLB = KGtoLB(weightKG);
    }

    // helper
    public int LBtoKG(int lb) { return (int) (lb * 0.45359237); }
    public int KGtoLB(int kg) { return (int) (kg / 0.45359237); }
}
