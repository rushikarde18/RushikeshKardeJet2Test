package com.s.rushikeshkardejet2test.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.s.rushikeshkardejet2test.R;
import com.s.rushikeshkardejet2test.model.Result;
import com.s.rushikeshkardejet2test.utils.Constants;

import java.util.ArrayList;

public class EmployeeDetailsActivity extends AppCompatActivity {
    TextView tvFirstName;
    TextView tvLastName;
    ImageView ivProfile;
    TextView tvDOB;
    TextView tvLocation;
    TextView tvEmail;
    TextView tvPhoneNumber;


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

            tvFirstName.setText(String.valueOf(getIntent().getStringExtra(Constants.KEY_FIRST_NAME)));
            tvLastName.setText(String.valueOf(getIntent().getStringExtra(Constants.KEY_LAST_NAME)));
            tvDOB.setText(String.valueOf(getIntent().getStringExtra(Constants.KEY_EMAIL)));
            tvLocation.setText(String.valueOf(getIntent().getStringExtra(Constants.KEY_LOCATION)));
            tvEmail.setText(String.valueOf(getIntent().getStringExtra(Constants.KEY_EMAIL)));
            tvPhoneNumber.setText(String.valueOf(getIntent().getStringExtra(Constants.KEY_PHONE_NUMBER)));
            setProfileImage(getIntent().getStringExtra(Constants.KEY_IMAGE_URL));
        }
    }

    private void setProfileImage(String imageURL) {
        Glide.with(ivProfile.getContext())
                .setDefaultRequestOptions(new RequestOptions()
                        .circleCrop())
                .load(imageURL)
                .placeholder(R.drawable.loading)
                .into(ivProfile);
    }

    private void initUI() {
        tvFirstName = (TextView) findViewById(R.id.tv_first_name);
        tvLastName = (TextView) findViewById(R.id.tv_last_name);
        tvDOB = (TextView) findViewById(R.id.tv_dob);
        tvLocation = (TextView) findViewById(R.id.tv_location);
        tvEmail= (TextView) findViewById(R.id.tv_email);
        tvPhoneNumber= (TextView) findViewById(R.id.tv_phone_number);
        ivProfile =(ImageView) findViewById(R.id.iv_profile_pic);

    }

   
}
