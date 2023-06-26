package com.example.gymlog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

<<<<<<< HEAD
import java.util.List;

public class ExerciseAdapter extends ArrayAdapter<String> {
    private List<String> dataList;
    private LayoutInflater inflater;

    public ExerciseAdapter(@NonNull Context context, List<String> dataList) {
        super(context, 0, dataList);
        this.dataList = dataList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.exercise_layout, parent, false);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.txtWorkout);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String data = dataList.get(position);
        holder.textView.setText(data);

        return convertView;
    }
    private static class ViewHolder {
        TextView textView;
=======
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
>>>>>>> 6e21de853a6d66e061d9863505ac7a325f143392
    }
}
