package com.example.roomdatabase18102021.data.repositories;

import com.example.roomdatabase18102021.data.local.WorkDao;
import com.example.roomdatabase18102021.data.local.WorkEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class WorkRepository {
    private WorkDao workDao;

    public WorkRepository(WorkDao workDao){
        this.workDao = workDao;
    }

    public Observable<List<WorkEntity>> getListWorks(){
        return workDao.getListWorks();
    }
}
