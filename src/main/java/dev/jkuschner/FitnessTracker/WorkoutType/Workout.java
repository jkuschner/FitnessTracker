package dev.jkuschner.FitnessTracker.WorkoutType;

import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Workout(
        @Positive
        Integer id,
        LocalDateTime startTime,
        LocalDateTime endTime,
        WorkoutType workoutType

) {

    public Workout {
        if(startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("endTime must be after startTime");
        }
    }
}
