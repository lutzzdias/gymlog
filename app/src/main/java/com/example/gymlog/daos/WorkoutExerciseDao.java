package com.example.gymlog.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.gymlog.entities.WorkoutExercise;

import java.util.List;

@Dao
public interface WorkoutExerciseDao {
    @Query("SELECT * FROM workout_exercises")
    LiveData<List<WorkoutExercise>> getAll();

    @Query("SELECT * FROM workout_exercises WHERE workout_id = :workoutId")
    LiveData<List<WorkoutExercise>> getExercisesByWorkoutId(String workoutId);

    @Insert
    void insert(WorkoutExercise workoutExercise);

    @Delete
    void delete(WorkoutExercise workoutExercise);
}
