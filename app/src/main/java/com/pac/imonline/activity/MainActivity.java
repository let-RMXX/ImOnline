package com.pac.imonline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toolbar;

import com.pac.imonline.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar Configuration
        Toolbar toolbar = findViewById(R.id.principalToolbar);
        toolbar.setTitle("Im Online");
        setSupportActionBar(toolbar);

    }

}