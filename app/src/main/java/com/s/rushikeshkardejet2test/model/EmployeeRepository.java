package com.s.rushikeshkardejet2test.model;

import androidx.lifecycle.MutableLiveData;


import com.s.rushikeshkardejet2test.network.EmployeeDataService;
import com.s.rushikeshkardejet2test.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeRepository {


    private static final String TAG = "EmployeeRepository";
    private ArrayList<Result> employees = new ArrayList<>();
    private MutableLiveData<List<Result>> mutableLiveData = new MutableLiveData<>();

    public EmployeeRepository() {
    }

    public MutableLiveData<List<Result>> getMutableLiveData() {

        final EmployeeDataService userDataService = RetrofitClient.getService();

        Call<EmployeeDBResponse> call = userDataService.getEmployees();
        call.enqueue(new Callback<EmployeeDBResponse>() {
            @Override
            public void onResponse(Call<EmployeeDBResponse> call, Response<EmployeeDBResponse> response) {
                EmployeeDBResponse employeeDBResponse = response.body();
                if (employeeDBResponse != null && employeeDBResponse.getResults() != null) {
                    employees = (ArrayList<Result>) employeeDBResponse.getResults();
                    mutableLiveData.setValue(employees);
                }
            }

            @Override
            public void onFailure(Call<EmployeeDBResponse> call, Throwable t) {
            }
        });

        return mutableLiveData;
    }
}
