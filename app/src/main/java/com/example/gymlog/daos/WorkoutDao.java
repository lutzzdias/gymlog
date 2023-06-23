package com.example.gymlog.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.gymlog.entities.Exercise;
import com.example.gymlog.entities.Workout;

import java.util.List;

@Dao
public interface WorkoutDao {
    @Query("SELECT * FROM workouts")
    List<Workout> getAll();

    @Query("SELECT * FROM workouts WHERE id = :workoutId")
    Workout getById(int workoutId);

    @Insert
    void insert(Workout workout);

    @Delete
    void delete(Workout workout);
}
