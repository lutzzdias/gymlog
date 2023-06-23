package com.example.gymlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        bNavigationView = findViewById(R.id.bottom_navigation);
        bNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.mnBtDumbbell){
               return true;
            }else if (item.getItemId() == R.id.mnBtPlus){
                Intent btDumbell = new Intent(this, Exercise_activity.class);
                startActivity(btDumbell);
                return true;
            }else if(item.getItemId() == R.id.mnBtHistory){
                return true;
            }else {
                return false;
            }
        });
    }




}