package com.s.rushikeshkardejet2test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeDBResponse {

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    private final static long serialVersionUID = -8639352977838290920L;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
