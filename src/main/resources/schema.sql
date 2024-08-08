CREATE TABLE IF NOT EXISTS Workout (
    id INT NOT NULL,
    start_time timestamp NOT NULL,
    end_time timestamp NOT NULL,
    activity varchar(20) NOT NULL,
    PRIMARY KEY (id)
);