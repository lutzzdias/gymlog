package com.example.gymlog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.gymlog.entities.Exercise;
import com.example.gymlog.viewmodels.ExerciseViewModel;

public class CreateExercise extends AppCompatActivity {

    private ExerciseViewModel exerciseViewModel;
    private EditText exerciseName;
    private EditText exerciseGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exercise);
        exerciseName = findViewById(R.id.edtAWTitle);
        exerciseGroup = findViewById(R.id.edtAWGroup);
        exerciseViewModel = new ViewModelProvider(this).get(ExerciseViewModel.class);
        //ImageButton
        ImageButton iBClose = findViewById(R.id.iBttClose);
        iBClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        //ButtonCreateExercise
        Button bCreateExercise = findViewById(R.id.btnAddWorkout);
        bCreateExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = exerciseName.getText().toString();
                String muscleGroup = exerciseGroup.getText().toString();
                Exercise exercise = new Exercise(name, muscleGroup);
                exerciseViewModel.insert(exercise);
            }
        });
    }
}