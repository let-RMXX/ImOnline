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

public class ProfileActivityMain extends AppCompatActivity implements EducationAdapter.EducationAdapterEventListener{
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
            // Referencias das RecyclerViews
            recyclerViewEducation = findViewById(R.id.recyclerViewEducation);
            recyclerViewWork = findViewById(R.id.recyclerViewWork);

            AppDatabase db = AppDatabase.getInstance(this);
            EducationDAO educationDAO = db.getEducationDAO();
            WorkDAO workDAO = db.getWorkDAO();
            educationAdapter = new EducationAdapter(this);

            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerViewEducation.setAdapter(educationAdapter);
            recyclerViewEducation.setLayoutManager(layoutManager);

            List<EducationActivity> educationActivityList = new ArrayList<>();
            // Buttons / ClickListeners
            buttonEditProfile = findViewById(R.id.button_editProfile);
            buttonEditProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openEditProfileActivity();
                }
            });

            buttonEditEducation = findViewById(R.id.button_editEducation);
            buttonEditEducation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openEditEducationActivity();
                }
            });

            buttonEditWork = findViewById(R.id.button_editWork);
            buttonEditWork.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openEditWorkActivity();
                }
            });
        }

        // ButtonActions
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

