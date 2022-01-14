package com.example.roomdatabase18102021.data.local;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

@Dao
public interface WorkDao {

    @Query("SELECT * FROM work")
    Observable<List<WorkEntity>> getListWorks();
}
