package com.pac.imonline.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pac.imonline.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.ViewHolder>{


    private List<EducationActivity> educationActivityList;
    private EducationAdapterEventListener eventListener;

    public EducationAdapter(EducationAdapterEventListener eventListener) {
        this.educationActivityList = new ArrayList<>();
        this.eventListener = eventListener;
    }

    @NonNull
    @Override
    public EducationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.education_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EducationAdapter.ViewHolder holder, int position) {
        final EducationActivity educationActivity = educationActivityList.get(position);
        holder.uni_name.setText(educationActivity.getUniversity_name());
        holder.date.setText(educationActivity.getDate());
        holder.graduation.setText(educationActivity.getGraduation());
        holder.description.setText(educationActivity.getDescription());
    }

    @Override
    public int getItemCount() {
        return educationActivityList.size();
    }

    public void refreshList(List<EducationActivity> newEducationList) {
        educationActivityList = newEducationList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView uni_name;
        public TextView date;
        public TextView graduation;
        public TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            uni_name = itemView.findViewById(R.id.textViewUniversityName);
            date = itemView.findViewById(R.id.textViewDate);
            graduation = itemView.findViewById(R.id.textViewGraduation);
            description = itemView.findViewById(R.id.textViewDescription);
        }
    }

    public interface EducationAdapterEventListener {

    }
}


