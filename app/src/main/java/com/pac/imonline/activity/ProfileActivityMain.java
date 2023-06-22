package com.pac.imonline.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pac.imonline.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivityMain extends AppCompatActivity {
    private EducationAdapter educationAdapter;
    private List<EducationActivity> educationActivityList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewEducation);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(this.educationAdapter);
        recyclerView.setLayoutManager(layoutManager);

        educationActivityList = new ArrayList<>();
    }
}

