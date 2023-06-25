package com.example.gymlog.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.gymlog.entities.Workout;
import com.example.gymlog.repositories.WorkoutRepository;

import java.util.List;

public class WorkoutViewModel extends AndroidViewModel {

    final private WorkoutRepository repository;

    public final LiveData<List<Workout>> workouts;

    public WorkoutViewModel (Application application) {
        super(application);
        repository = new WorkoutRepository(application);
        workouts = repository.getWorkouts();
    }

    public LiveData<List<Workout>> getWorkouts() { return workouts; }

    public void insert(Workout workout) { repository.insert(workout); }
    public void delete(Workout workout) { repository.delete(workout); }
}
