package com.s.rushikeshkardejet2test.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.s.rushikeshkardejet2test.R;
import com.s.rushikeshkardejet2test.model.Result;
import com.s.rushikeshkardejet2test.utils.Constants;

import java.util.ArrayList;

public class EmployeeDetailsActivity extends AppCompatActivity {
    TextView tvFirstName;
    TextView tvLastName;
    ImageView imageView;
    TextView tvDOB;
    TextView tvLocation;
    TextView tvEmail;
    TextView PhoneNumber;


    ArrayList<Result> employees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        initUI();

        if(null != getIntent())
        {
            employees = new ArrayList<>();
            getIntent().getSerializableExtra(Constants.KEY_PASS_DATA);
        }
    }

    private void initUI() {
        tvFirstName = (TextView) findViewById(R.id.tv_first_name);
    }
}
