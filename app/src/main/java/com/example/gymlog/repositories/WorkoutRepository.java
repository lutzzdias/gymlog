package com.example.gymlog.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.gymlog.daos.WorkoutDao;
import com.example.gymlog.database.AppDatabase;
import com.example.gymlog.entities.Workout;

import java.util.List;

public class WorkoutRepository {

    private WorkoutDao workoutDao;
    private LiveData<List<Workout>> workouts;

    public WorkoutRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        workoutDao = db.workoutDao();
        workouts = workoutDao.getAll();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Workout>> getWorkouts() {
        return workouts;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Workout workout) {
        AppDatabase.databaseWriteExecutor.execute(() -> workoutDao.insert(workout));
    }
}
