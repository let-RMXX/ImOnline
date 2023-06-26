package com.pac.imonline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

        //ProfileActivity newProfile = new ProfileActivity(0,name, about, phone, "", location);
    }
}