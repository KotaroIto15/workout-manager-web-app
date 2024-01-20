package com.kotaroito.workoutmanagerbackend.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kotaroito.workoutmanagerbackend.model.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {}