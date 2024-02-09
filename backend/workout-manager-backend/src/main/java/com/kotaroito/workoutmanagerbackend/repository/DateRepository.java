package com.kotaroito.workoutmanagerbackend.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kotaroito.workoutmanagerbackend.model.Date;
import com.kotaroito.workoutmanagerbackend.model.Date.DateId;

@Repository
public interface DateRepository extends JpaRepository<Date, DateId> {}
