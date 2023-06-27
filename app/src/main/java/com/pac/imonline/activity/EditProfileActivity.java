package com.pac.imonline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.pac.imonline.R;

public class EditProfileActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, EditProfileActivity.class);
        context.startActivity(intent);
    }

    TextInputEditText textInputEditTextName;
    TextInputEditText textInputEditTextAbout;
    TextInputEditText textInputEditTextPhone;
    TextInputEditText textInputEditTextEmail;
    TextInputEditText textInputEditTextLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        this.textInputEditTextName = findViewById(R.id.textInputEditTextName);
        this.textInputEditTextAbout = findViewById(R.id.textInputEditTextAbout);
        this.textInputEditTextPhone = findViewById(R.id.textInputEditTextPhone);
        this.textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail);
        this.textInputEditTextLocation = findViewById(R.id.textInputEditTextLocation);
    }

    public void editProfile(View view){
        String name = this.textInputEditTextName.getText().toString();
        String about = this.textInputEditTextAbout.getText().toString();
        String phone = this.textInputEditTextPhone.getText().toString();
        String email = this.textInputEditTextEmail.getText().toString();
        String location = this.textInputEditTextLocation.getText().toString();
        //TODO CORRIGIR ISTO PARA DEPOIS DEFINIR OS CAMPOS DO PERFIL NA MAIN PARA TESTAR
        ProfileActivity newProfile = new ProfileActivity(0, "", name, about, phone, email, location);

        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewAbout = findViewById(R.id.textViewAbout);
        TextView textViewPhone = findViewById(R.id.textViewPhone);
        TextView textViewEmail = findViewById(R.id.textViewEmail);
        TextView textViewLocation = findViewById(R.id.textViewLocation);

        textViewName.setText(newProfile.getName());
        textViewAbout.setText(newProfile.getAbout());
        textViewPhone.setText(newProfile.getPhoneNumber());
        textViewEmail.setText(newProfile.getEmail());
        textViewLocation.setText(newProfile.getLocation());

        AppDatabase.getInstance(this).getProfileDAO().insert(newProfile);
        finish();

        //TextView textViewName = findViewById(R.id.textViewName);
        //TextView textViewAbout = findViewById(R.id.textViewAbout);
        //TextView textViewPhone = findViewById(R.id.textViewPhone);
        //TextView textViewEmail = findViewById(R.id.textViewEmail);
        //TextView textViewLocation = findViewById(R.id.textViewLocation);

        //extViewName.setText(name);
        //textViewAbout.setText(about);
        //textViewPhone.setText(phone);
        //textViewEmail.setText(email);
        //textViewLocation.setText(location);
    }
}