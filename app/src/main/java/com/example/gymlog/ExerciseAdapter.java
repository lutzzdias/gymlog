package com.example.gymlog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gymlog.entities.Exercise;
import com.example.gymlog.entities.Workout;

import java.util.ArrayList;

public class ExerciseAdapter extends ArrayAdapter<Exercise> {
    public ExerciseAdapter(Context context, ArrayList<Exercise> exerciseList){
        super(context, R.layout.custom_workout_item, exerciseList);
    }

    @NonNull
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        View currentItemView = view;
        if(currentItemView == null){
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_workout_item,
                    parent, false);
        }

        Exercise exercisePosition = getItem(position);

        TextView exerciseName = currentItemView.findViewById(R.id.WEName);
        exerciseName.setText(exercisePosition.getName());

        TextView muscleGroup = currentItemView.findViewById(R.id.WEMuscleGroup);
        muscleGroup.setText(exercisePosition.getMuscleGroup());

        return currentItemView;
    }
}
