package com.kotaroito.workoutmanagerbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kotaroito.workoutmanagerbackend.dto.CreateScheduleDTO;
import com.kotaroito.workoutmanagerbackend.model.Schedule;
import com.kotaroito.workoutmanagerbackend.service.ScheduleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CreateScheduleController {

    @Autowired 
    ScheduleService scheduleService;

    @PostMapping("/schedule/register")
    public ResponseEntity<Schedule> postMethodName(@RequestBody CreateScheduleDTO scheduleInfo) {
        Schedule newSchedule = scheduleInfo.generateSchedule();
        scheduleService.createSchedule(newSchedule);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
