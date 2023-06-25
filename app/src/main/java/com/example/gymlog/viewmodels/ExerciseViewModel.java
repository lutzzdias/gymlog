package com.example.gymlog.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.gymlog.entities.Exercise;
import com.example.gymlog.repositories.ExerciseRepository;

import java.util.List;

public class ExerciseViewModel extends AndroidViewModel {

    final private ExerciseRepository repository;

    public final LiveData<List<Exercise>> exercises;

    public ExerciseViewModel (Application application) {
        super(application);
        repository = new ExerciseRepository(application);
        exercises = repository.getExercises();
    }

    public LiveData<List<Exercise>> getExercises() { return exercises; }

    public void insert(Exercise exercise) { repository.insert(exercise); }
}
