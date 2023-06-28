package com.pac.imonline.activity.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pac.imonline.R;

import java.util.ArrayList;
import java.util.List;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.ViewHolder> {

    private List<WorkActivity> listWork;
    private WorkAdapterEventListener eventListener;

    /**
     * Construtor que um objeto que implemente o interface ContactAdapterEventListener
     * @param eventListener
     */
    public WorkAdapter(WorkAdapterEventListener eventListener){
        this.listWork = new ArrayList<>();
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.work_experience_item, parent,false);
        return new ViewHolder(view);
    }
    /**
     * Permite associar a um ViewHolder dados de um item da lista
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final WorkActivity work = this.listWork.get(position);

        holder.textViewCompanyName.setText(work.getCompany_name());
        holder.textViewDateWork.setText(work.getDate());
        holder.textViewRole.setText(work.getRole());
        holder.textViewDescriptionWork.setText(work.getDescription());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (eventListener != null){
                    eventListener.onWorkLongClicked(work.getId());
                    return true;
                } else {
                    return false;
                }
            }
        });

        }


    @Override
    public int getItemCount() {
        return listWork.size();
    }

    public void refreshListWork(List<WorkActivity> newWorkList){
        listWork = newWorkList;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewCompanyName;
        public TextView textViewDateWork;
        public TextView textViewRole;
        public TextView textViewDescriptionWork;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCompanyName = (TextView) itemView.findViewById(R.id.textViewCompanyName);
            textViewDateWork = (TextView) itemView.findViewById(R.id.textViewDateWork);
            textViewRole = (TextView) itemView.findViewById(R.id.textViewRole);
            textViewDescriptionWork = (TextView) itemView.findViewById(R.id.textViewDescriptionWork);
        }
    }

    public interface WorkAdapterEventListener {

        void onWorkLongClicked(long workId);
    }
}
