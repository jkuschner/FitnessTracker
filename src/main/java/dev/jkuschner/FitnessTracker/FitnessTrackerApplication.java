package dev.jkuschner.FitnessTracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitnessTrackerApplication {

	private static final Logger log = LoggerFactory.getLogger(FitnessTrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FitnessTrackerApplication.class, args);
		log.info("Hello World!");
	}

	/*
	@Bean
	CommandLineRunner runner(WorkoutRepository workoutRepository) {
		return args -> {
			Workout workout = new Workout(1, LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), Activity.CARDIO);
			workoutRepository.create(workout);
		};
	}
	 */
}
