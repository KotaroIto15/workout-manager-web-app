package com.kotaroito.workoutmanagerbackend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kotaroito.workoutmanagerbackend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String Username);
    
}