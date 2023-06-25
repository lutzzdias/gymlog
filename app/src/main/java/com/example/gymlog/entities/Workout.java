package com.example.gymlog.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.UUID;

@Entity(tableName = "workouts")
public class Workout {
    @PrimaryKey @NonNull
    public String id;
    public String name;
    public Date date;

    @Ignore
    public Workout(String name, Date date) {
        this(UUID.randomUUID().toString(), name, date);
    }

    public Workout(String id, String name, Date date){
        this.id = id;
        this.name = name;
        this.date = date;
    }
}
