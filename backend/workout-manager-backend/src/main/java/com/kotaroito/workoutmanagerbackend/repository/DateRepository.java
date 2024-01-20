package com.kotaroito.workoutmanagerbackend.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kotaroito.workoutmanagerbackend.model.Date;

@Repository
public interface DateRepository extends JpaRepository<Date, Long> {}
