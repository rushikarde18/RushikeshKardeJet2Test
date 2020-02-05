package com.s.rushikeshkardejet2test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.s.rushikeshkardejet2test.adapter.EmployeeDataAdapter;
import com.s.rushikeshkardejet2test.databinding.ActivityMainBinding;
import com.s.rushikeshkardejet2test.model.Result;
import com.s.rushikeshkardejet2test.viewmodels.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private EmployeeDataAdapter employeeDataAdapter;
    List<Result> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        // bind RecyclerView
        RecyclerView recyclerView = activityMainBinding.viewEmployees;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        employeeDataAdapter = new EmployeeDataAdapter();
        recyclerView.setAdapter(employeeDataAdapter);

        employeeList = new ArrayList<Result>();

        for (int i = 0; i < 2; i++) {
            getAllEmployee();
        }
    }

    private void getAllEmployee() {
        mainViewModel.getAllEmployee().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(@Nullable List<Result> employees) {

                for (Result result : employees ) {
                    employeeList.add(result);
                }
                employeeDataAdapter.setEmployeeList((ArrayList<Result>) employeeList);

            }
        });
    }

}
