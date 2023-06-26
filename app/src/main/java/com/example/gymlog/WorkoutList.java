package com.example.gymlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WorkoutList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        Context context = this;


        //ImageButton - Troca de treino para exercicio
        ImageButton change = findViewById(R.id.ImageButtonAW);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ExerciseList.class);
                startActivity(intent);
            }
        });


        //BottomNavigationView
        BottomNavigationView navigationB = findViewById(R.id.bottom_navigationAWL);
        navigationB.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.mnBtDumbbell){
                return true;
            }else if(item.getItemId() == R.id.mnBtPlus){
                Intent workoutIntent = new Intent(context, ActiveWorkout.class);
                startActivity(workoutIntent);
            }else if(item.getItemId() == R.id.mnBtHistory){
                Intent historyIntent = new Intent(context, WorkoutHistory.class);
                startActivity(historyIntent);
            }
            return false;
        });
    }
}