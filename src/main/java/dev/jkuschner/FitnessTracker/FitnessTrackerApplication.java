package dev.jkuschner.FitnessTracker;

import dev.jkuschner.FitnessTracker.Activity.Activity;
import dev.jkuschner.FitnessTracker.Activity.Workout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class FitnessTrackerApplication {

	private static final Logger log = LoggerFactory.getLogger(FitnessTrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FitnessTrackerApplication.class, args);
		log.info("Hello World!");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Workout workout = new Workout(1, LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), Activity.CARDIO);
			log.info("Workout: " + workout);
		};
	}
}
