package com.example.roomdatabase18102021.data.local;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {WorkEntity.class}, version = 1)
public abstract class WorkDatabase extends RoomDatabase {
    private static WorkDatabase instance = null;
    public WorkDao workDao;

    public synchronized static WorkDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(
                    context,
                    WorkDatabase.class,
                    "work"
            )
                    .build();
        }
        return instance;
    }

}
