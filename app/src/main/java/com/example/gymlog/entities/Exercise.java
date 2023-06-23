package com.example.gymlog.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "exercises")
public class Exercise {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    @ColumnInfo(name="muscle_group")
    public String muscleGroup;

    public Exercise(String name, String muscleGroup){
        this.name = name;
        this.muscleGroup = muscleGroup;
    }
}
