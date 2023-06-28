package com.pac.imonline.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pac.imonline.R;

import java.util.ArrayList;
import java.util.List;

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.ViewHolder>{


    private List<EducationActivity> educationActivityList;
    private EducationAdapterEventListener eventListener;

    /**
     * Construtor que um objeto que implemente o interface ContactAdapterEventListener
     * @param eventListener
     */

    public EducationAdapter(EducationAdapterEventListener eventListener) {
        this.educationActivityList = new ArrayList<>();
        this.eventListener = eventListener;
    }
    /**
     * Criar um novo ViewHolder sempre que for necessário
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */


    @NonNull
    @Override
    public EducationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.education_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EducationAdapter.ViewHolder holder, int position) {
        final EducationActivity educationActivity = this.educationActivityList.get(position);

        holder.uni_name.setText(educationActivity.getUniversity_name());
        holder.date.setText(educationActivity.getDate());
        holder.graduation.setText(educationActivity.getGraduation());
        holder.description.setText(educationActivity.getDescription());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (eventListener != null) {
                    eventListener.onEducationLongClicked(educationActivity.getId());
                    return true;
                } else {
                    return false;
                }
            }
        });
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
            uni_name = itemView.findViewById(R.id.textViewCompanyName);
            date = itemView.findViewById(R.id.textViewDateWork);
            graduation = itemView.findViewById(R.id.textViewRole);
            description = itemView.findViewById(R.id.textViewDescriptionWork);
        }
    }

    public interface EducationAdapterEventListener {
        void onEducationLongClicked(long educationActivityId);

    }
}


