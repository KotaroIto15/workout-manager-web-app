package com.kotaroito.workoutmanagerbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.io.Serializable;

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
@IdClass(Date.DateId.class)
public class Date {

    public class DateId implements Serializable {
        private String date;
        private User user;

        // constructor
        public DateId() {}
        public DateId(String date, User user) {
            this.date = date;
            this.user = user;
        }

        // getters
        public String getDate() { return this.date; }
        public User getUser() { return this.user; }

        // setters
        public void setDate(String date) { this.date = date; }
        public void setUser(User user) { this.user = user; }

        // equals
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DateId dateId = (DateId) o;
            return this.date.equals(dateId.date) && this.user.equals(dateId.user);
        }

        // hashcode
        @Override
        public int hashCode() {
            return this.date.hashCode() + this.user.hashCode();
        }

    }

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