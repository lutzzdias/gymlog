    package com.example.gymlog.entities;

<<<<<<< HEAD
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
=======
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
>>>>>>> 6e21de853a6d66e061d9863505ac7a325f143392
