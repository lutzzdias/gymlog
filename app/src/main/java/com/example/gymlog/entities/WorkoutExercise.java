package com.example.gymlog.entities;

import static com.example.gymlog.database.AppDatabase.CASCADE;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.UUID;


@Entity(tableName = "workout_exercises",
        foreignKeys = {
            @ForeignKey(entity = Workout.class, parentColumns = "id", childColumns = "workout_id", onDelete = CASCADE),
            @ForeignKey(entity = Exercise.class, parentColumns = "id", childColumns = "exercise_id", onDelete = CASCADE),
        },
        indices = {@Index(value = {"workout_id"}), @Index(value = {"exercise_id"})}
)
public class WorkoutExercise {
    @PrimaryKey @NonNull
    public String id;
    @ColumnInfo(name = "workout_id")
    public String workoutId;
    @ColumnInfo(name = "exercise_id")
    public String exerciseId;
    public int sets;
    public int reps;
    public int weight;

    @Ignore
    public WorkoutExercise(String workoutId, String exerciseId, int sets, int reps, int weight) {
        this(UUID.randomUUID().toString(), workoutId, exerciseId, sets, reps, weight);
    }

    public WorkoutExercise(String id, String workoutId, String exerciseId, int sets, int reps, int weight){
        this.id = id;
        this.workoutId = workoutId;
        this.exerciseId = exerciseId;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }
}
