package com.example.gymlog.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.gymlog.daos.ExerciseDao;
import com.example.gymlog.daos.WorkoutDao;
import com.example.gymlog.entities.Exercise;
import com.example.gymlog.entities.Workout;
import com.example.gymlog.helper.DateHelper;

@Database(entities = {Workout.class, Exercise.class}, version = 1)
@TypeConverters({DateHelper.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract WorkoutDao workoutDao();
    public abstract ExerciseDao ExerciseDao();
}
