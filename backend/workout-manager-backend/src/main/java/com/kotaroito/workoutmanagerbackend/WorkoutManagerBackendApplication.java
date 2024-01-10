package com.kotaroito.workoutmanagerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.kotaroito.workoutmanagerbackend.model")
public class WorkoutManagerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkoutManagerBackendApplication.class, args);
	}

}
