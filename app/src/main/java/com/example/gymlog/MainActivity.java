package com.example.gymlog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.gymlog.database.AppDatabase;
import com.example.gymlog.entities.Exercise;
import com.example.gymlog.viewmodels.ExerciseViewModel;

public class MainActivity extends AppCompatActivity {
    private ExerciseViewModel exerciseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exerciseViewModel = new ViewModelProvider(this).get(ExerciseViewModel.class);

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
    }
}