package dev.jkuschner.FitnessTracker.Activity;

import java.time.LocalDateTime;

public record Workout(
        Integer id,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Activity activity

) {}
