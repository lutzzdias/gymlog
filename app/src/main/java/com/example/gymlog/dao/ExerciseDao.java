package com.example.gymlog.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import com.example.gymlog.entities.Exercise;

@Dao
public interface ExerciseDao {
    @Query("SELECT * FROM exercises")
    List<Exercise> getAll();

    @Query("SELECT * FROM exercises WHERE id = :exerciseId")
    Exercise getById(int exerciseId);

    @Insert
    void insert(Exercise exercise);

    @Delete
    void delete(Exercise exercise);
}
