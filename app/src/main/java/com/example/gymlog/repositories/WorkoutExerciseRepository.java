package com.example.gymlog.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.gymlog.daos.WorkoutExerciseDao;
import com.example.gymlog.database.AppDatabase;
import com.example.gymlog.entities.WorkoutExercise;

import java.util.List;

public class WorkoutExerciseRepository {

    private WorkoutExerciseDao workoutExerciseDao;
    private LiveData<List<WorkoutExercise>> workoutExercises;

    public WorkoutExerciseRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        workoutExerciseDao = db.workoutExerciseDao();
        workoutExercises = workoutExerciseDao.getAll();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<WorkoutExercise>> getWorkoutExercises() {
        return workoutExercises;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(WorkoutExercise workoutExercise) {
        AppDatabase.databaseWriteExecutor.execute(() -> workoutExerciseDao.insert(workoutExercise));
    }

    public void delete(WorkoutExercise workoutExercise) {
        AppDatabase.databaseWriteExecutor.execute(() -> workoutExerciseDao.delete(workoutExercise));
    }
}
