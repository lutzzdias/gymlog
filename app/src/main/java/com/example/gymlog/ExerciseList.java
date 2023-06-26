package com.example.gymlog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.gymlog.entities.Exercise;
import com.example.gymlog.viewmodels.ExerciseViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ExerciseList extends AppCompatActivity {


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);
        showExercise();

        Context context = this;
        //ImageButton
        ImageButton iBChange = findViewById(R.id.ImageButtonEA);
        iBChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //FloatingButton
        FloatingActionButton fab = findViewById(R.id.floatingButtonEA);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CreateExercise.class);
                startActivity(intent);
            }
            exer
        });

        //NavigationView
        BottomNavigationView navigationB = findViewById(R.id.bottom_navigationAEL);
        navigationB.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.mnBtDumbbell){
               finish();
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

    public void showExercise() {
        ArrayList<Exercise> arrayListExercise = new ArrayList<>();
        ExerciseViewModel exerciseViewModel = new ViewModelProvider(this).get(ExerciseViewModel.class);
        listView = findViewById(R.id.lvWorkout);
        exerciseViewModel.exercises.observe(this, arrayListExercise::addAll);

        ExerciseAdapter exerAdapter = new ExerciseAdapter(ExerciseList.this, arrayListExercise);
        listView.setAdapter(exerAdapter);
    }


}