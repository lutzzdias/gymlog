package com.example.gymlog.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "exercises")
public class Exercise {
    @PrimaryKey
    public int id;
    public String name;
    @ColumnInfo(name="muscle_group")
    public String muscleGroup;

    public Exercise() { }
}
