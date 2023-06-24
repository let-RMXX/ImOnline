package com.pac.imonline.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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
    private Button buttonEditProfile;
    private Button buttonEditEducation;
    private Button buttonEditWork;

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
        //Buttons / ClickListeners
        buttonEditProfile = (Button) findViewById(R.id.button_editProfile);
        buttonEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditProfileActivity();
            }
        });

        buttonEditEducation = (Button) findViewById(R.id.button_editEducation);
        buttonEditEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditEducationActivity();
            }
        });

        buttonEditWork = (Button) findViewById(R.id.button_editWork);
        buttonEditWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditWorkActivity();
            }
        });
    }

    //ButtonActions
    public void openEditProfileActivity() {
        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivity(intent);
    }

    public void openEditEducationActivity() {
        Intent intent = new Intent(this, EditEducationActivity.class);
        startActivity(intent);

    }

    public void openEditWorkActivity() {
        Intent intent = new Intent(this, EditWorkActivity.class);
        startActivity(intent);
    }
}

