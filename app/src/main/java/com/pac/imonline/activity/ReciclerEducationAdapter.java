package com.pac.imonline.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pac.imonline.R;

import java.util.ArrayList;

public class ReciclerEducationAdapter extends RecyclerView.Adapter<ReciclerEducationAdapter.MyViewHolder> {
    private ArrayList<EducationActivity> educationList;

    public ReciclerEducationAdapter(ArrayList<EducationActivity> educationList){this.educationList = educationList;}
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView university;
        private TextView date;
        private TextView graduation;
        private TextView description;

    public MyViewHolder(final View view){
        super(view);
        university = view.findViewById(R.id.textViewUniversityName);
        date = view.findViewById(R.id.textViewDate);
        graduation = view.findViewById(R.id.textViewGraduation);
        description = view.findViewById(R.id.textViewDescription);
    }
    }

    @NonNull
    @Override
    public ReciclerEducationAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.education_item,parent,false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ReciclerEducationAdapter.MyViewHolder holder, int position) {
        String university_name = educationList.get(position).getUniversity_name();
        holder.university.setText(university_name);

        String date = educationList.get(position).getDate();
        holder.date.setText(date);

        String graduation = educationList.get(position).getGraduation();
        holder.graduation.setText(graduation);

        String description = educationList.get(position).getDescription();
        holder.description.setText(description);
    }

    @Override
    public int getItemCount() {return educationList.size();
    }
}
