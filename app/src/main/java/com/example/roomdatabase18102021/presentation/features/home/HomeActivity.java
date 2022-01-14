package com.example.roomdatabase18102021.presentation.features.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.roomdatabase18102021.R;
import com.example.roomdatabase18102021.data.local.WorkDatabase;
import com.example.roomdatabase18102021.data.local.WorkEntity;
import com.example.roomdatabase18102021.data.repositories.WorkRepository;
import com.example.roomdatabase18102021.presentation.viewmodels.HomeViewModel;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    HomeViewModel mHomeViewModel;
    WorkRepository mWorkRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        WorkDatabase workDatabase = WorkDatabase.getInstance(getApplicationContext());
        mWorkRepository = new WorkRepository(workDatabase.workDao());
        mHomeViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
                return (T) new HomeViewModel(mWorkRepository);
            }
        }).get(HomeViewModel.class);

        // observer data
        mHomeViewModel.getListWordsLiveData().observe(this, new Observer<List<WorkEntity>>() {
            @Override
            public void onChanged(List<WorkEntity> workEntities) {
                if (workEntities != null){
                    Log.d("BBB","Size " + workEntities.size());
                }
            }
        });

        mHomeViewModel.getErrorLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (!s.isEmpty()){
                    Log.d("BBB","Error : " + s );
                }
            }
        });
        // event

        mHomeViewModel.queryListWorks();
    }
}