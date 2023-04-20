package com.pac.imonline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.pac.imonline.R;
import com.pac.imonline.activity.model.User;

public class RegisterActivity extends AppCompatActivity {

    private EditText userField, emailField, passwordField;
    private Button registerButton;
    private ProgressBar progressBar;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeComponents();

        // User Register
        progressBar.setVisibility(View.GONE);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                String userText = userField.getText().toString();
                String emailText = emailField.getText().toString();
                String passwordText = passwordField.getText().toString();

                if( !userText.isEmpty()) {
                    if( !emailText.isEmpty()) {
                        if( !passwordText.isEmpty()) {

                            user = new User();
                            user.setName(userText);
                            user.setEmail(emailText);
                            user.setPassword(passwordText);

                            registerUser(user);

                }else{
                            Toast.makeText(RegisterActivity.this,
                                    "Insert your password",
                                    Toast.LENGTH_SHORT).show();

                }

                }else{

                        Toast.makeText(RegisterActivity.this,
                                "Insert your email",
                                Toast.LENGTH_SHORT).show();

                }

                }else{

                    Toast.makeText(RegisterActivity.this,
                            "Insert your username",
                            Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    // method to register a user and make validations as we do it
    public void registerUser(User user){



    }

    public void initializeComponents(){

        userField = findViewById(R.id.username_register);
        emailField = findViewById(R.id.email_register);
        passwordField = findViewById(R.id.password_register);
        registerButton = findViewById(R.id.register_button);
        progressBar = findViewById(R.id.progress_bar_register);

    }

}