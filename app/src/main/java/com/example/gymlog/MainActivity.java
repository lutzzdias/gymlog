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
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ExerciseViewModel exerciseViewModel;
    private WorkoutViewModel workoutViewModel;
    private WorkoutExerciseViewModel workoutExerciseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViewModels();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> goToExerciseListScreen());

        Button createExerciseButton = findViewById(R.id.createExerciseButton);
        createExerciseButton.setOnClickListener(view -> createExerciseWithHardcodedData());

        Button createWorkoutButton = findViewById(R.id.createWorkoutButton);
        createWorkoutButton.setOnClickListener(view -> createWorkoutWithHardcodedData());

        Button createWorkoutExerciseButton = findViewById(R.id.createWorkoutExerciseButton);
        createWorkoutExerciseButton.setOnClickListener(view -> createWorkoutExerciseWithHardcodedData());

        Button getExerciseByIdButton = findViewById(R.id.getExerciseById);
        getExerciseByIdButton.setOnClickListener(view -> getExerciseById());

        Button logDataButton = findViewById(R.id.logDataButton);
        logDataButton.setOnClickListener(view -> logDataIntoConsole());
    }

    private void initializeViewModels() {
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
    }

    private void goToExerciseListScreen() {
        Intent intent = new Intent(this, ExerciseList.class);
        startActivity(intent);
    }

    private void createExerciseWithHardcodedData() {
        Exercise exercise = new Exercise("Rosca Direta na Polia", "Bíceps");
        System.out.println("exercise: " + exercise.id);
        exerciseViewModel.insert(exercise);
    }

    private void createWorkoutWithHardcodedData() {
        Workout workout = new Workout("Costas e Bíceps", new Date());
        System.out.println("workout: " + workout.id);
        workoutViewModel.insert(workout);
    }

    // Every time the database is cleaned the workoutId and exerciseId must be changed here
    private void createWorkoutExerciseWithHardcodedData() {
        WorkoutExercise workoutExercise = new WorkoutExercise("414367cf-adbd-4c96-9f44-6d4968e702fd", "1e70a1a1-8d15-4da6-be5d-2b5a5093ea91", 3, 10, 20);
        workoutExerciseViewModel.insert(workoutExercise);
    }

    private void getExerciseById() {
        exerciseViewModel.getExerciseById("fe21f1c5-7484-4f56-b8f4-4776986caa55");
        exerciseViewModel.exercise.observe(this, ex -> {
            System.out.println(ex.name);
        });
    }

    private void logDataIntoConsole() {
        System.out.println(exerciseViewModel.getExercises().getValue());
        System.out.println(workoutViewModel.getWorkouts().getValue());
        System.out.println(workoutExerciseViewModel.getWorkoutExercises().getValue());
    }
}