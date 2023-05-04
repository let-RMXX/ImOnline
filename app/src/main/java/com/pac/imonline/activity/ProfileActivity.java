package com.pac.imonline.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.pac.imonline.R;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private ArrayList<WorkActivity> workList;
    private RecyclerView recyclerView;
    private Button button_editprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        recyclerView = findViewById(R.id.recyclerViewWork);
        workList = new ArrayList<>();

        setUserInfo();
        setAdapter();

        button_editprofile = (Button) findViewById(R.id.button_editprofile);
        button_editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditProfileActivity();
            }
        });
    }

    private void setAdapter() {
        ReciclerWorkAdapter adapter = new ReciclerWorkAdapter(workList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    private void setUserInfo() {
        workList.add(new WorkActivity("Ferrari", "2020-2022", "Mechanic", "Very good very nice mechanic"));
        workList.add(new WorkActivity("Continente", "2019-Present", "Operador de Loja", "Very good very nice repositor"));
    }

    public void openEditProfileActivity(){
        Intent editprofile = new Intent(this, EditProfileActivity.class);
        startActivity(editprofile);
    }

}

