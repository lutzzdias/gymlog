package com.example.gymlog.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.gymlog.daos.ExerciseDao;
import com.example.gymlog.database.AppDatabase;
import com.example.gymlog.entities.Exercise;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ExerciseRepository {

    private ExerciseDao exerciseDao;
    private LiveData<List<Exercise>> exercises;

    public ExerciseRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        exerciseDao = db.exerciseDao();
        exercises = exerciseDao.getAll();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Exercise>> getExercises() { return exercises; }

    public LiveData<Exercise> getExerciseById(String id) {
        return exerciseDao.getById(id);
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Exercise exercise) {
        AppDatabase.databaseWriteExecutor.execute(() -> exerciseDao.insert(exercise));
    }

    public void delete(Exercise exercise) {
        AppDatabase.databaseWriteExecutor.execute(() -> exerciseDao.delete(exercise));
    }
}