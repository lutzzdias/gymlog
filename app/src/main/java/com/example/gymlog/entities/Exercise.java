package com.example.gymlog.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "exercises")
public class Exercise {
    @PrimaryKey @NonNull
    public String id;
    public String name;
    @ColumnInfo(name="muscle_group")
    public String muscleGroup;

    @Ignore
    public Exercise(String name, String muscleGroup) {
        this(UUID.randomUUID().toString(), name, muscleGroup);
    }

    public Exercise(String id, String name, String muscleGroup){
        this.id = id;
        this.name = name;
        this.muscleGroup = muscleGroup;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }
}
