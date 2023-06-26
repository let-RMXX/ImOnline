package com.pac.imonline.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.pac.imonline.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void openRegisterPage (View view){

        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);

    }
}