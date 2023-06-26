package com.pac.imonline.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pac.imonline.R;


import java.util.List;

public class ProfileActivityMain extends AppCompatActivity implements EducationAdapter.EducationAdapterEventListener, WorkAdapter.WorkAdapterEventListener{
        private EducationAdapter educationAdapter;
        private WorkAdapter workAdapter;
        private Button buttonEditProfile;
        private Button buttonEditEducation;
        private Button buttonEditWork;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);

            //RecyclerViews
            RecyclerView recyclerViewEducation = findViewById(R.id.recyclerViewEducation);
            AppDatabase db = AppDatabase.getInstance(this);
            EducationDAO educationDAO = db.getEducationDAO();
            this.educationAdapter = new EducationAdapter(this);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerViewEducation.setAdapter(this.educationAdapter);
            recyclerViewEducation.setLayoutManager(layoutManager);









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
        @Override
        protected void onStart(){
            super.onStart();
            List<EducationActivity> newEducationList = AppDatabase.getInstance(this).getEducationDAO().getAll();
            this.educationAdapter.refreshList(newEducationList);
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

