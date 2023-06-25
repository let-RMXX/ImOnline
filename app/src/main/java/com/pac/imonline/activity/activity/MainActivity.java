package com.pac.imonline.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.pac.imonline.R;

public class MainActivity extends AppCompatActivity {

    //private dataBaseAuth dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar Configuration
        Toolbar toolbar = findViewById(R.id.principalToolbar);
        toolbar.setTitle("Im Online");
        setSupportActionBar(toolbar);

        //databaseAuth = databaseConfig.getDatabaseConfig();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

            return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case R.id.signout_menu:

                userSignOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                break;

        }

        return super.onOptionsItemSelected(item);

    }

    private void userSignOut(){

        try {

                //databaseAuth.signOut();

        }catch (Exception e){

            e.printStackTrace();

        }

    }

}