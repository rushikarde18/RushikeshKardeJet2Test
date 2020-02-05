package com.s.rushikeshkardejet2test.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.s.rushikeshkardejet2test.model.EmployeeRepository;
import com.s.rushikeshkardejet2test.model.Result;

import java.util.List;

//For MVVM
public class MainViewModel extends AndroidViewModel {
    private EmployeeRepository employeeRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        employeeRepository = new EmployeeRepository();
    }

    public LiveData<List<Result>> getAllEmployee() {
        return employeeRepository.getMutableLiveData();
    }
}
