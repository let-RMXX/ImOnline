package com.pac.imonline.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.pac.imonline.R;

import java.util.ArrayList;

public class ProfileActivityMain extends AppCompatActivity {

    private ArrayList<WorkActivity> workList;
    private ArrayList<EducationActivity> educationList;
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewedu;

    private Button button_editprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //recyclerView = findViewById(R.id.recyclerViewWork);

    }
}

