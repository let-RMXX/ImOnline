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

import java.util.List;

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.ViewHolder> {

    private List<EducationActivity> educationList;

    public EducationAdapter(List<EducationActivity> educationList, Context context) {
        this.educationList = educationList;
        this.context = context;
    }

    private Context context;

    public EducationAdapter() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.education_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EducationActivity educationItem = educationList.get(position);
        holder.uni_name.setText(educationItem.getUniversity_name());
        holder.date.setText(educationItem.getDate());
        holder.graduation.setText(educationItem.getGraduation());
        holder.description.setText(educationItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return educationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView uni_name;
        public TextView date;
        public TextView graduation;
        public TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            uni_name = (TextView) itemView.findViewById(R.id.textViewUniversityName);
            date = (TextView) itemView.findViewById(R.id. textViewDate);
            graduation = (TextView) itemView.findViewById(R.id.textViewGraduation);
            description = (TextView)  itemView.findViewById(R.id.textViewDescription);
        }
    }
}
