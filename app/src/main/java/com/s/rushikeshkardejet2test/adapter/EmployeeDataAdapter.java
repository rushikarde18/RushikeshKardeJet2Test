package com.s.rushikeshkardejet2test.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.s.rushikeshkardejet2test.R;
import com.s.rushikeshkardejet2test.databinding.EmployeeListItemBinding;
import com.s.rushikeshkardejet2test.model.Result;
import com.s.rushikeshkardejet2test.utils.Constants;

import java.util.ArrayList;

public class EmployeeDataAdapter extends RecyclerView.Adapter<EmployeeDataAdapter.EmployeeViewHolder> {

    private ArrayList<Result> employees;
    private Context context;

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        EmployeeListItemBinding employeeListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.employee_list_item, viewGroup, false);
        context = viewGroup.getContext();
        return new EmployeeViewHolder(employeeListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder employeeViewHolder, final int i) {
        Result currentStudent = employees.get(i);
        employeeViewHolder.employeeListItemBinding.setEmployee(currentStudent);

        employeeViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });


        employeeViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                removeAt(i);
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        if (employees != null) {
            return employees.size();
        } else {
            return 0;
        }
    }

    public void setEmployeeList(ArrayList<Result> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private EmployeeListItemBinding employeeListItemBinding;

        public EmployeeViewHolder(@NonNull EmployeeListItemBinding employeetListItemBinding) {
            super(employeetListItemBinding.getRoot());

            this.employeeListItemBinding = employeetListItemBinding;
        }
    }

    public void removeAt(int position) {
        employees.remove(position);
        notifyItemRemoved(position);
       notifyDataSetChanged();
    }

}
