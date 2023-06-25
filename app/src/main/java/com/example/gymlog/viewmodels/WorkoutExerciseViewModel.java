package com.example.gymlog.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.gymlog.entities.WorkoutExercise;
import com.example.gymlog.repositories.WorkoutExerciseRepository;

import java.util.List;

public class WorkoutExerciseViewModel extends AndroidViewModel {

    final private WorkoutExerciseRepository repository;

    public final LiveData<List<WorkoutExercise>> workoutExercises;

    public WorkoutExerciseViewModel(Application application) {
        super(application);
        repository = new WorkoutExerciseRepository(application);
        workoutExercises = repository.getWorkoutExercises();
    }

    public LiveData<List<WorkoutExercise>> getWorkoutExercises() { return workoutExercises; }

    public void insert(WorkoutExercise workoutExercise) { repository.insert(workoutExercise); }
}
