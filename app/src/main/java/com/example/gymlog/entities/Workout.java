package com.example.gymlog.entities;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;

@Entity(tableName = "workouts")
public class Workout {
    @PrimaryKey
    public int id;
    public String name;
    public Date date;
    @Embedded
    public List<Exercise> exercises;
}
