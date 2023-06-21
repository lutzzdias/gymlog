package com.example.gymlog.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.gymlog.dao.ExerciseDao;
import com.example.gymlog.dao.WorkoutDao;
import com.example.gymlog.entities.Exercise;
import com.example.gymlog.entities.Workout;

@Database(entities = {Workout.class, Exercise.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WorkoutDao workoutDao();
    public abstract ExerciseDao ExerciseDao();
}
