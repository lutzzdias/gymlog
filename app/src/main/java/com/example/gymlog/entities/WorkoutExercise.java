package com.example.gymlog.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "workout_exercises",
        foreignKeys = {
            @ForeignKey(entity = Workout.class, parentColumns = "id", childColumns = "workoutId" ),
            @ForeignKey(entity = Exercise.class, parentColumns = "id", childColumns = "exerciseId" ),
        })
public class WorkoutExercise {
    @PrimaryKey
    public int id;
    public int workoutId;
    public int exerciseId;
    public int sets;
    public int reps;
    public int weight;
}
