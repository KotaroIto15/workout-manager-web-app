package com.kotaroito.workoutmanagerbackend.service;

import java.util.List;

import com.kotaroito.workoutmanagerbackend.model.Schedule;
import com.kotaroito.workoutmanagerbackend.model.User;

public interface ScheduleService {
    
    public List<Schedule> getAllSchedules(User user);
    public Schedule getScheduleById(Long id);
    public void createSchedule(Schedule schedule);
    public void deleteSchedule(Long id);
    public void addWorkoutToSchedule(Long scheduleId, Long workoutId);

}