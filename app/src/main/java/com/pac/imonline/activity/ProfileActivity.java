package com.pac.imonline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pac.imonline.R;

public class ProfileActivity extends AppCompatActivity {

    private Button button_editprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        button_editprofile = (Button) findViewById(R.id.button_editprofile);
        button_editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditProfileActivity();
            }
        });
    }

    public void openEditProfileActivity(){
        Intent editprofile = new Intent(this, EditProfileActivity.class);
        startActivity(editprofile);
    }
}

