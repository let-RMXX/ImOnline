package com.pac.imonline.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.pac.imonline.R;
import com.pac.imonline.activity.activity.DatabaseAuth;
import com.pac.imonline.activity.activity.LoginActivity;
import com.pac.imonline.helper.DatabaseConfig;

public class MainActivity extends AppCompatActivity {

    private DatabaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar Config
        Toolbar toolbar = findViewById(R.id.toolbarMain);
        toolbar.setTitle("Im Online");
        setSupportActionBar(toolbar);

        //object config
        auth = DatabaseConfig.getDatabaseAuth();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menuSignOut:
                signOutUser();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                break;

        }

        return super.onOptionsItemSelected(item);

    }

    private void signOutUser(){

        try {

            auth.signOut();

        }catch (Exception e){

            e.printStackTrace();

        }

    }

}