package dev.jkuschner.FitnessTracker.Activity;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WorkoutRepository {

    //private List<Workout> workouts = new ArrayList<>();
    private static final Logger log = LoggerFactory.getLogger(WorkoutRepository.class);
    private final JdbcClient jdbcClient;

    public WorkoutRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    public List<Workout> findAll() {
        return jdbcClient.sql("select * from workout")
                .query(Workout.class)
                .list();
    }

    public Optional<Workout> findById(Integer id) {
        return jdbcClient.sql("SELECT id,start_time,end_time,activity FROM Workout WHERE id = :id")
                .param("id", id)
                .query(Workout.class)
                .optional();
    }

    public void create(Workout workout) {
        var updated = jdbcClient.sql("INSERT INTO Workout(id,start_time,end_time,activity) values(?,?,?,?)")
                .params(List.of(workout.id(), workout.startTime(), workout.endTime(), workout.activity().toString()))
                .update();

        Assert.state(updated == 1, "Failed to create workout " + workout.id());
    }

    public void update(Workout workout, Integer id) {
        var updated = jdbcClient.sql("update workout set start_time = ?, end_time = ?, activity = ? where id = ?")
                .params(List.of(workout.startTime(),workout.endTime(),workout.activity().toString(), id))
                .update();

        Assert.state(updated == 1, "Failed to update workout " + workout.id());
    }

    public void delete(Integer id) {
        var updated = jdbcClient.sql("delete from workout where id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete run " + id);
    }

    public int count() {
        return jdbcClient.sql("select * from workout")
                .query()
                .listOfRows()
                .size();
    }

    public void saveAll(List<Workout> workouts) {
        workouts.stream().forEach(this::create);
    }

    public List<Workout> findByActivity(String activity) {
        return jdbcClient.sql("select * from workout where activity = :activity")
                .param("activity", activity)
                .query(Workout.class)
                .list();
    }

    /*
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
    */
}
