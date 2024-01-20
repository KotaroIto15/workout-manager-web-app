package com.kotaroito.workoutmanagerbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(
    name = "Dates",
    uniqueConstraints = @UniqueConstraint(columnNames = { "date", "user_id" })
)
public class Date {

    @Id
    @Column(
        name = "date",
        updatable = false,
        nullable = false,
        columnDefinition = "DATE"
    )
    private String date;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", updatable = false)
    private User user;

    @ManyToOne(optional = true)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    // constructor
    public Date() {}
    public Date(String date, User user) { 
        this.date = date;
        this.user = user; 
    }
    public Date(String date, Schedule schedule) {
        this.date = date;
        this.schedule = schedule;
    }

    // getters
    public String getDate() { return this.date; }
    public User getUser() { return this.user; }
    public Schedule getSchedule() { return this.schedule; }

    // setters
    public void setSchedule(Schedule schedule) { this.schedule = schedule; }
}