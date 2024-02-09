package com.kotaroito.workoutmanagerbackend.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.kotaroito.workoutmanagerbackend.model.Schedule;
import com.kotaroito.workoutmanagerbackend.model.User;
import com.kotaroito.workoutmanagerbackend.model.Workout;
import com.kotaroito.workoutmanagerbackend.repository.UserRepository;

public class CreateScheduleDTO {

    @Autowired
    private UserRepository userRepository;

    private long userId;
    private List<Workout> workouts;

    public long getUserId() {
        return this.userId;
    }

    public List<Workout> getWorkouts() {
        return this.workouts;
    }

    public Schedule generateSchedule() {
        User user = userRepository.findById(userId).get();
        return new Schedule(user, workouts);
    }

}
