package com.kotaroito.workoutmanagerbackend.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String scheduleName;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<Workout> workouts;

    //constructors
    public Schedule() {};
    public Schedule(User user, String name) {
        this.user = user;
        this.scheduleName = name;
        this.workouts = null;
    }

    //getters
    public Long getScheduleId() { return this.scheduleId; }
    public User getUser() { return this.user; }
    public String getScheduleName() { return this.scheduleName; }
    public List<Workout> getWorkouts() { return this.workouts; }

    //setters
    public void setScheduleId(Long scheduleId) { this.scheduleId = scheduleId; }
    public void setUser(User user) { this.user = user; }
    public void setScheduleName(String scheduleName) { this.scheduleName = scheduleName; }
    public void setWorkouts(List<Workout> workouts) { this.workouts = workouts; }

    // workouts manipulation
    public void addWorkout(Workout workout) {
        this.workouts.add(workout);
    }

    public void removeWorkout(Workout workout) {
        this.workouts.remove(workout);
    }

    public void removeAllWorkouts() {
        this.workouts.clear();
    }

    public void updateWorkout(Workout workout, int index) {
        this.workouts.set(index, workout);
    }

}
