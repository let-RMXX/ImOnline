package com.pac.imonline.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pac.imonline.R;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private ArrayList<WorkActivity> workList;
    private ArrayList<EducationActivity> educationList;
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewedu;

    private Button button_editprofile;
//Input texto, nome, about, etc.....
    String name;
    //Cod do input text
    EditText editTextTextProfileName = (EditText) findViewById(R.id.editTextTextProfileName);
    TextView textViewProfileName;
    Button button_apply = (Button) findViewById(R.id.button_apply);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        recyclerView = findViewById(R.id.recyclerViewWork);
        workList = new ArrayList<>();


        recyclerViewedu = findViewById(R.id.recyclerViewEducation);
        educationList = new ArrayList<>();


//SET info/adapter para as RecicleViews
        setUserInfo();
        setUserInfo2();
        setAdapter();
        setAdapter2();
        textViewProfileName = (TextView) findViewById(R.id.textViewProfileName);
        button_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = textViewProfileName.getText().toString();



            }
        });


        button_editprofile = (Button) findViewById(R.id.button_editprofile);
        // button edit para passar para outra activity
        button_editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditProfileActivity();
            }
        });
    }
// RecicleView Work
    private void setAdapter() {
        ReciclerWorkAdapter adapter = new ReciclerWorkAdapter(workList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }
//Dados da RecicleView Work(Editar aqui)
    private void setUserInfo() {
        workList.add(new WorkActivity("Ferrari", "2020-2022", "Mechanic", "Very good very nice mechanic"));
        workList.add(new WorkActivity("Continente", "2019-Present", "Operador de Loja", "Very good very nice repositor"));
    }
//Ação do button Edit
    public void openEditProfileActivity(){
        Intent editprofile = new Intent(this, EditProfileActivity.class);
        startActivity(editprofile);
    }
// RecicleView Education
    private void setAdapter2(){
        ReciclerEducationAdapter adapter = new ReciclerEducationAdapter(educationList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager((getApplicationContext()));
        recyclerViewedu.setLayoutManager(layoutManager);
        recyclerViewedu.setItemAnimator(new DefaultItemAnimator());
        recyclerViewedu.setAdapter(adapter);
    }
    //Dados da RecicleView Education(Editar aqui)
    private void setUserInfo2(){
        educationList.add((new EducationActivity("ESTIG","2022-Present","CTeSP","very good very nice")));
    }

    //Update text dos EditText(Edit Profile)
    public void updateText(View view){
        textViewProfileName.setText(editTextTextProfileName.getText());
    }
}

