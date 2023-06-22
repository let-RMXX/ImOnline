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
    private RecyclerView recyclerViewEducation;
    private RecyclerView recyclerViewWork;
    private EducationAdapter educationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //Referencias das RecyclerViews
        RecyclerView recyclerViewEducation = findViewById(R.id.recyclerViewEducation);
        RecyclerView recyclerViewWork = findViewById(R.id.recyclerViewWork);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //Adapters
        //educationAdapter = new EducationAdapter();

        recyclerViewEducation.setAdapter(this.educationAdapter);
        recyclerViewEducation.setLayoutManager(layoutManager);

        List<EducationActivity> educationActivityList = new ArrayList<>();
    }
}

