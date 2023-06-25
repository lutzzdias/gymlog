package com.example.gymlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WorkoutHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_workouts);

        Context context = this;

        //BottomNavigationView
        BottomNavigationView navigationB = findViewById(R.id.bottom_navigationHW);
        navigationB.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.mnBtDumbbell){
                Intent WEIntent = new Intent(context, WorkoutList.class);
                startActivity(WEIntent);
            }else if(item.getItemId() == R.id.mnBtPlus){
                Intent workoutIntent = new Intent(context, ActiveWorkout.class);
                startActivity(workoutIntent);
            }else if(item.getItemId() == R.id.mnBtHistory){
                return true;
            }
            return false;
        });
    }
}