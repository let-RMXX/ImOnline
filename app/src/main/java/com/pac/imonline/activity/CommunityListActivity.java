package com.pac.imonline.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pac.imonline.R;

import java.util.ArrayList;
import java.util.List;

public class CommunityListActivity extends AppCompatActivity {

    private RecyclerView communityRecyclerView;
    private CommunityAdapter communityAdapter;
    private List<Community> communityList;
    private CommunityDao communityDao;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_list);

        communityRecyclerView = findViewById(R.id.communityRecyclerView);
        communityRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        communityList = new ArrayList<>();
        communityAdapter = new CommunityAdapter(communityList);
        communityRecyclerView.setAdapter(communityAdapter);

        appDatabase = AppDatabase.getInstance(this);
        communityDao = appDatabase.getCommunityDao();

        communityDao.getAllCommunities().observe(this, new Observer<List<Community>>() {
            @Override
            public void onChanged(List<Community> community) {
                communityList.clear();
                communityList.addAll(community);

                // Add a test item to the communityList
                Community testCommunity = new Community("Test Community", "https://i.pinimg.com/originals/f1/e6/64/f1e664fd61bb3e9d53f528b97d1d34fb.jpg", "https://hdqwalls.com/wallpapers/dark-souls-3-8k-om.jpg", false);
                communityList.add(testCommunity);

                communityAdapter.notifyDataSetChanged();
            }
        });
    }

    public void onCreateCommunityClicked(View view) {
        Intent intent = new Intent(this, CreateCommunityActivity.class);
        startActivity(intent);
    }
}

