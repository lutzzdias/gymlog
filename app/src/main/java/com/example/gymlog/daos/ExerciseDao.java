package com.example.gymlog.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import com.example.gymlog.entities.Exercise;

@Dao
public interface ExerciseDao {
    @Query("SELECT * FROM exercises")
    LiveData<List<Exercise>> getAll();

    @Query("SELECT * FROM exercises WHERE id = :exerciseId")
    LiveData<Exercise> getById(String exerciseId);

    @Insert
    void insert(Exercise exercise);

    @Delete
    void delete(Exercise exercise);
}
