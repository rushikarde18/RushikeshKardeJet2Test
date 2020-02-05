package com.s.rushikeshkardejet2test.network;


import com.s.rushikeshkardejet2test.model.EmployeeDBResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeDataService {
  @GET("api")
  Call<EmployeeDBResponse> getEmployees();
}
