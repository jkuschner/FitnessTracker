package dev.jkuschner.FitnessTracker.Activity;

import jakarta.annotation.PostConstruct;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WorkoutRepository {

    private List<Workout> workouts = new ArrayList<>();

    List<Workout> findAll() {
        return workouts;
    }

    Optional<Workout> findById(Integer id) {
        return workouts.stream()
                .filter(workout -> workout.id() == id)
                .findFirst();
    }

    void create(Workout workout) {
        workouts.add(workout);
    }

    void update(Workout workout, Integer id) {
        Optional<Workout> existingWorkout = findById(id);
        if(existingWorkout.isPresent()) {
            workouts.set(workouts.indexOf(existingWorkout.get()), workout);
        }
    }

    void delete(Integer id) {
        workouts.removeIf(workout -> workout.id().equals(id));
    }

    @PostConstruct
    private void init() {
        workouts.add(new Workout(1,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                Activity.GYM));


        workouts.add(new Workout(2,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(90),
                Activity.HITTING));
    }
}
