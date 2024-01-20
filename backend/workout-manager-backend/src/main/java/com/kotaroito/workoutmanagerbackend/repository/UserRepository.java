package com.kotaroito.workoutmanagerbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kotaroito.workoutmanagerbackend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public boolean existsByEmail(String email);
    public User findByEmail(String email);
}