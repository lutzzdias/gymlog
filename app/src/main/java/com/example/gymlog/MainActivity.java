package com.example.gymlog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.gymlog.database.AppDatabase;
import com.example.gymlog.entities.Exercise;
import com.example.gymlog.entities.Workout;
import com.example.gymlog.viewmodels.ExerciseViewModel;
import com.example.gymlog.viewmodels.WorkoutViewModel;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ExerciseViewModel exerciseViewModel;
    private WorkoutViewModel workoutViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exerciseViewModel = new ViewModelProvider(this).get(ExerciseViewModel.class);
        workoutViewModel = new ViewModelProvider(this).get(WorkoutViewModel.class);

        exerciseViewModel.exercises.observe(this, exercises -> {
            exercises.forEach(exercise -> System.out.println(exercise.name));
        });
        workoutViewModel.workouts.observe(this, workouts -> {
            workouts.forEach(workout -> System.out.println(workout.name));
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, ExerciseList.class);
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

        Button logDataButton = findViewById(R.id.logDataButton);
        logDataButton.setOnClickListener(view -> {
            System.out.println(exerciseViewModel.getExercises().getValue());
            System.out.println(workoutViewModel.getWorkouts().getValue());
        });
    }
}