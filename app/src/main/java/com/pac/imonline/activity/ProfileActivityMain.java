package com.pac.imonline.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
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

            //RecyclerView EDUCATION
            RecyclerView recyclerViewEducation = findViewById(R.id.recyclerViewEducation);
            AppDatabase db = AppDatabase.getInstance(this);
            EducationDAO educationDAO = db.getEducationDAO();
            this.educationAdapter = new EducationAdapter(this);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerViewEducation.setAdapter(this.educationAdapter);
            recyclerViewEducation.setLayoutManager(layoutManager);


            //RecyclerView WORK
            RecyclerView recyclerViewWork = findViewById(R.id.recyclerViewWork);
            AppDatabase db1 = AppDatabase.getInstance(this);
            WorkDAO workDAO = db1.getWorkDAO();
            this.workAdapter = new WorkAdapter(this);
            LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
            recyclerViewWork.setAdapter(this.workAdapter);
            recyclerViewWork.setLayoutManager(layoutManager1);

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

            List<WorkActivity> newWorkList = AppDatabase.getInstance(this).getWorkDAO().getAll();
            this.workAdapter.refreshListWork(newWorkList);
        }

        public void openEditEducationActivity() {
            Intent intent = new Intent(this, EditEducationActivity.class);
            startActivity(intent);
        }



        public void openEditWorkActivity() {
            Intent intent = new Intent(this, EditWorkActivity.class);
            startActivity(intent);
        }

        //EDUCATION LONG CLICKED DÁ POP UP DA ALERTDIALOG PARA APAGAR OU NÃO A INFO
    @Override
    public void onEducationLongClicked(long educationActivityId) {
        EducationDAO educationDAO = AppDatabase.getInstance(ProfileActivityMain.this).getEducationDAO();
        EducationActivity educationActivity = educationDAO.getById(educationActivityId);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Delete info");
        builder.setMessage("Do you want to delete this information? " );
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                educationDAO.delete(educationActivity);
                List<EducationActivity> newList = educationDAO.getAll();
                educationAdapter.refreshList(newList);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onWorkLongClicked(long workId) {
            WorkDAO workDAO = AppDatabase.getInstance(ProfileActivityMain.this).getWorkDAO();
            WorkActivity workActivity = workDAO.getById(workId);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Delete info");
            builder.setMessage("Do you want to delete this information? ");

            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    workDAO.delete(workActivity);
                    List<WorkActivity> newList = workDAO.getAll();
                    workAdapter.refreshListWork(newList);
                    dialog.dismiss();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

    }
}

