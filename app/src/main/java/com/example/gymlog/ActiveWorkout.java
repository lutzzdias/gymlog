package com.example.gymlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActiveWorkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_workout);

        Context context = this;

        //BottomNavigationView
        BottomNavigationView navigationB = findViewById(R.id.bottom_navigationAAW);
        navigationB.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.mnBtDumbbell){
                Intent WEIntent = new Intent(context, WorkoutList.class);
                startActivity(WEIntent);
            }else if(item.getItemId() == R.id.mnBtPlus){
                return true;
            }else if(item.getItemId() == R.id.mnBtHistory){
                Intent historyIntent = new Intent(context, WorkoutHistory.class);
                startActivity(historyIntent);
            }
            return false;
        });
    }
}