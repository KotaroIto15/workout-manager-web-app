package com.kotaroito.workoutmanagerbackend.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kotaroito.workoutmanagerbackend.model.Schedule;
import com.kotaroito.workoutmanagerbackend.model.User;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByUser(User user);
}