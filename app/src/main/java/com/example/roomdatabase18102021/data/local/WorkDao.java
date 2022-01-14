package com.example.roomdatabase18102021.data.local;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface WorkDao {

    @Query("SELECT * FROM work")
}
