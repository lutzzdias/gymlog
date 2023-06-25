package com.example.gymlog.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.gymlog.entities.WorkoutExercise;
import com.example.gymlog.repositories.WorkoutExerciseRepository;

import java.util.List;

public class WorkoutExerciseViewModel extends AndroidViewModel {

    final private WorkoutExerciseRepository repository;

    public final LiveData<List<WorkoutExercise>> allWorkoutExercises;
    public LiveData<List<WorkoutExercise>> workoutExercises;

    public WorkoutExerciseViewModel(Application application) {
        super(application);
        repository = new WorkoutExerciseRepository(application);
        allWorkoutExercises = repository.getAll();
    }

    public LiveData<List<WorkoutExercise>> getAll() { return allWorkoutExercises; }

    public LiveData<List<WorkoutExercise>> getWorkoutExercises(String workoutId) {
        workoutExercises = repository.getWorkoutExercises(workoutId);
        return workoutExercises;
    }

    public void insert(WorkoutExercise workoutExercise) { repository.insert(workoutExercise); }
    public void delete(WorkoutExercise workoutExercise) { repository.delete(workoutExercise); }
}
