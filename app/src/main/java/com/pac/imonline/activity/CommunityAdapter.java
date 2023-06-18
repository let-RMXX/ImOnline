package com.pac.imonline.activity;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pac.imonline.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.CommunityViewHolder> {

    private List<Community> communityList;

    public CommunityAdapter(List<Community> communityList) {
        this.communityList = communityList;
    }

    @NonNull
    @Override
    public CommunityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_community, parent, false);
        return new CommunityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityViewHolder holder, int position) {
        Community community = communityList.get(position);

        holder.bind(community);
    }

    @Override
    public int getItemCount() {
        return communityList.size();
    }

    public class CommunityViewHolder extends RecyclerView.ViewHolder {

        private ImageView photoImageView;
        private ImageView bannerImageView;
        private TextView nameTextView;
        private ImageView ownerBadge;

        public CommunityViewHolder(@NonNull View itemView) {
            super(itemView);

            photoImageView = itemView.findViewById(R.id.photoImageView);
            bannerImageView = itemView.findViewById(R.id.bannerImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            ownerBadge = itemView.findViewById(R.id.ownerBadge);
        }

        public void bind(Community community) {
            // Load the images using an image loading library (e.g., Picasso or Glide)
            Picasso.get().load(community.getPhotoUrl()).into(photoImageView);
            Picasso.get().load(community.getBannerUrl()).into(bannerImageView);

            nameTextView.setText(community.getName());

            if (community.isOwner()) {
                ownerBadge.setVisibility(View.VISIBLE);
            } else {
                ownerBadge.setVisibility(View.GONE);
            }
        }
    }
}



