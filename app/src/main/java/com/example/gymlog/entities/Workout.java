package com.example.gymlog.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;

@Entity(tableName = "workouts")
public class Workout {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public Date date;

    public Workout(String name, Date date){
        this.name = name;
        this.date = date;
    }
}
