package com.pac.imonline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.pac.imonline.R;

import java.util.List;

public class EditProfileActivity extends AppCompatActivity {


    public static void start(Context context) {
        Intent intent = new Intent(context, EditProfileActivity.class);
        context.startActivity(intent);
    }

    EditText editTextName;
    EditText editTextAbout;
    EditText editTextPhone;
    EditText editTextEmail;
    EditText editTextLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        this.editTextName = findViewById(R.id.editTextName);
        this.editTextAbout = findViewById(R.id.editTextAbout);
        this.editTextPhone = findViewById(R.id.editTextPhone);
        this.editTextEmail = findViewById(R.id.editTextEmail);
        this.editTextLocation = findViewById(R.id.editTextLocation);
    }

    public void editProfile(View view){
        String name = this.editTextName.getText().toString();
        String about = this.editTextAbout.getText().toString();
        String phone = this.editTextPhone.getText().toString();
        String email = this.editTextEmail.getText().toString();
        String location = this.editTextLocation.getText().toString();

        int profileId=1;

        ProfileActivity currentProfile = AppDatabase.getInstance(this).getProfileDAO().getById(profileId);

        if ((currentProfile != null)){
            currentProfile.updateProfile(name, about, phone, email, location);

            AppDatabase.getInstance(this).getProfileDAO().updateProfile(currentProfile);
            finish();
        } else {
            AppDatabase.getInstance(this).getProfileDAO().getById(profileId);
        }

        //ProfileActivity newProfile = new ProfileActivity(0,"", name, about, phone, email, location);

        //AppDatabase.getInstance(this).getProfileDAO().updateProfile(newProfile);
        //finish();
    }
}