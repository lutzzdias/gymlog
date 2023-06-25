package com.example.gymlog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.gymlog.entities.Exercise;
import com.example.gymlog.entities.Workout;
import com.example.gymlog.entities.WorkoutExercise;
import com.example.gymlog.viewmodels.ExerciseViewModel;
import com.example.gymlog.viewmodels.WorkoutExerciseViewModel;
import com.example.gymlog.viewmodels.WorkoutViewModel;

import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ExerciseViewModel exerciseViewModel;
    private WorkoutViewModel workoutViewModel;
    private WorkoutExerciseViewModel workoutExerciseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exerciseViewModel = new ViewModelProvider(this).get(ExerciseViewModel.class);
        workoutViewModel = new ViewModelProvider(this).get(WorkoutViewModel.class);
        workoutExerciseViewModel = new ViewModelProvider(this).get(WorkoutExerciseViewModel.class);

        exerciseViewModel.exercises.observe(this, exercises -> {
            exercises.forEach(exercise -> System.out.println(exercise.name));
        });
        workoutViewModel.workouts.observe(this, workouts -> {
            workouts.forEach(workout -> System.out.println(workout.name));
        });
        workoutExerciseViewModel.workoutExercises.observe(this, workoutExercises -> {
            workoutExercises.forEach(workoutExercise -> System.out.printf(Locale.US, "workoutId: %s - exerciseId: %s%n", workoutExercise.workoutId, workoutExercise.exerciseId));
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, WorkoutList.class);
            startActivity(intent);
        });

        Button createExerciseButton = findViewById(R.id.createExerciseButton);
        createExerciseButton.setOnClickListener(view -> {
            Exercise exercise = new Exercise("Rosca Direta na Polia", "Bíceps");
            System.out.println("exercise: " + exercise.name);
            exerciseViewModel.insert(exercise);
        });

        Button createWorkoutButton = findViewById(R.id.createWorkoutButton);
        createWorkoutButton.setOnClickListener(view -> {
            Workout workout = new Workout("Costas e Bíceps", new Date());
            System.out.println("workout: " + workout.name);
            workoutViewModel.insert(workout);
        });

        Button createWorkoutExerciseButton = findViewById(R.id.createWorkoutExerciseButton);
        createWorkoutExerciseButton.setOnClickListener(view -> {
            WorkoutExercise workoutExercise = new WorkoutExercise("5fc086df-de83-459e-b6f0-08b1c437f30d", "f166c764-a51f-4b83-9261-1dee45136729", 3, 10, 20);
            workoutExerciseViewModel.insert(workoutExercise);
        });

        Button logDataButton = findViewById(R.id.logDataButton);
        logDataButton.setOnClickListener(view -> {
            System.out.println(exerciseViewModel.getExercises().getValue());
            System.out.println(workoutViewModel.getWorkouts().getValue());
            System.out.println(workoutExerciseViewModel.getWorkoutExercises().getValue());
        });
    }
}