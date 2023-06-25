package com.example.gymlog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CreateExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exercise);


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
                //Criar a logica de salvar no banco


                finish();
            }
        });
    }
}