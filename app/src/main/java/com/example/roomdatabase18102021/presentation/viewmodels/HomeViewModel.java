package com.example.roomdatabase18102021.presentation.viewmodels;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabase18102021.data.local.WorkEntity;
import com.example.roomdatabase18102021.data.repositories.WorkRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {
    private WorkRepository workRepository;
    private MutableLiveData<List<WorkEntity>> listWorksLiveData = new MutableLiveData();
    private MutableLiveData<String> errorLiveData = new MutableLiveData();

    public HomeViewModel(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    public LiveData<List<WorkEntity>> getListWordsLiveData() {
        return listWorksLiveData;
    }

    public LiveData<String> getErrorLiveData() {
        return errorLiveData;
    }

    public void queryListWorks(){
        workRepository
                .getListWorks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<WorkEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<WorkEntity> workEntities) {
                        listWorksLiveData.setValue(workEntities);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        errorLiveData.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
