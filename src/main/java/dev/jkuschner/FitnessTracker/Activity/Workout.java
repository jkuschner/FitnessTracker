package dev.jkuschner.FitnessTracker.Activity;

import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Workout(
        @Positive
        Integer id,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Activity activity

) {

    public Workout {
        if(startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("endTime must be after startTime");
        }
    }
}
