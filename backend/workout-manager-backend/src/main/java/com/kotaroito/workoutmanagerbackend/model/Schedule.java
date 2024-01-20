package com.kotaroito.workoutmanagerbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Set;

@Entity
@Table(name = "Schedules")
public class Schedule {

    @Id
    @SequenceGenerator(
        name = "schedule_sequence",
        sequenceName = "schedule_sequence",
        initialValue = 1,
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "schedule_sequence"
    )
    private long scheduleId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "schedule")
    private Set<Workout> workouts;

    // constructors
    public Schedule() {}
    public Schedule(User user) {
        this.user = user;
        this.workouts = null;
    }

    // getters
    public long getId() { return this.scheduleId; }
    public User getUser() { return this.user; }
    public Set<Workout> getWorkouts() { return this.workouts; }

    // setters
    public void setId(long id) { this.scheduleId = id; }
    public void setUser(User user) { this.user = user; }
    public void setWorkouts(Set<Workout> workouts) { this.workouts = workouts; }
    public void addWorkout(Workout workout) { this.workouts.add(workout); }
    public void removeWorkout(Workout workout) { this.workouts.remove(workout); }
}