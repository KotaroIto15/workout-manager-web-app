package com.kotaroito.workoutmanagerbackend.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kotaroito.workoutmanagerbackend.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {}