package com.kotaroito.workoutmanagerbackend.model;

import java.util.Set;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
        name = "first_name",
        updatable = true,
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
        name = "last_name",
        updatable = true,
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String lastName;

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

    @Column(
        name = "email",
        updatable = true,
        nullable = false,
        unique = true,
        columnDefinition = "TEXT"
    )
    @Check(constraints = "email ~ '^[a-zA-Z0-9.!#$%&''*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$'")
    private String email;

    @Column(
        name = "password",
        updatable = true,
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Schedule> schedules;

    @OneToMany(mappedBy = "user")
    private Set<Date> calendar;

    // constructors
    public User() {}
    public User(String firstName, String lastName, String email, int height, int weight, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.height = height;
        this.weight = weight;
        this.password = password;
        this.schedules = null;
        this.calendar = null;
    };
    
    // getters
    public long getId() { return this.userId; }
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public int getHeight() { return this.height; }
    public int getWeight() { return this.weight; }
    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }

    //setters
    public void setId(Long id) { this.userId = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setHeight(int height) { this.height = height; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}