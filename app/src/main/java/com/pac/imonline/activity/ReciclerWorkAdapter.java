package com.pac.imonline.activity;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pac.imonline.R;

import java.util.ArrayList;

public class ReciclerWorkAdapter extends RecyclerView.Adapter<ReciclerWorkAdapter.MyViewHolder> {
    private ArrayList<WorkActivity> workList;

    public ReciclerWorkAdapter(ArrayList<WorkActivity> workList){
        this.workList = workList;
    }
    public  class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView company;
        private TextView date;
        private TextView role;
        private TextView description;

    public MyViewHolder(final View view){
        super(view);
        company = view.findViewById(R.id.textViewUniversityName);
        date = view.findViewById(R.id.textViewDate);
        role = view.findViewById(R.id.textViewGraduation);
        description = view.findViewById(R.id.textViewDescription);
    }

    }

    @NonNull
    @Override
    public ReciclerWorkAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_work,parent, false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ReciclerWorkAdapter.MyViewHolder holder, int position) {
        String company_name = workList.get(position).getCompany_name();
        holder.company.setText(company_name);

        String date = workList.get(position).getDate();
        holder.date.setText(date);

        String role = workList.get(position).getRole();
        holder.role.setText(role);

        String description = workList.get(position).getDescription();
        holder.description.setText(description);


    }

    @Override
    public int getItemCount() {
        return workList.size();
    }
}
