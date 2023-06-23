package com.example.gymlog.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.gymlog.daos.ExerciseDao;
import com.example.gymlog.daos.WorkoutDao;
import com.example.gymlog.entities.Exercise;
import com.example.gymlog.entities.Workout;
import com.example.gymlog.helper.DateHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Workout.class, Exercise.class}, version = 1)
@TypeConverters({DateHelper.class})
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static public AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "gymlog_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract WorkoutDao workoutDao();
    public abstract ExerciseDao exerciseDao();
}
