package com.kotaroito.workoutmanagerbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotaroito.workoutmanagerbackend.model.Schedule;
import com.kotaroito.workoutmanagerbackend.model.User;
import com.kotaroito.workoutmanagerbackend.repository.ScheduleRepository;
import com.kotaroito.workoutmanagerbackend.repository.WorkoutRepository;
import com.kotaroito.workoutmanagerbackend.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private final ScheduleRepository scheduleRepository;

    @Autowired final WorkoutRepository workoutRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, WorkoutRepository workoutRepository) {
        this.scheduleRepository = scheduleRepository;
        this.workoutRepository = workoutRepository;
    }

    public List<Schedule> getAllSchedules(User user) {
        return scheduleRepository.findByUser(user);
    };

    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id).orElse(null);
    };

    public void createSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    };

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    };

    public void addWorkoutToSchedule(Long scheduleId, Long workoutId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElse(null);
        schedule.getWorkouts().add(workoutRepository.findById(workoutId).orElse(null));
        scheduleRepository.save(schedule);
    };
}