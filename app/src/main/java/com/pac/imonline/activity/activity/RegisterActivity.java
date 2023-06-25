package com.pac.imonline.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.pac.imonline.R;
import com.pac.imonline.activity.activity.DatabaseAuth;
import com.pac.imonline.activity.activity.MainActivity;
import com.pac.imonline.helper.DatabaseConfig;
import com.pac.imonline.model.User;


public class RegisterActivity extends AppCompatActivity {

    private EditText userField, emailField, passwordField;
    private Button signInButton;
    private User user;

    private DatabaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inicializeComponents();

        // Sign In User
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userText = userField.getText().toString();
                String emailText = emailField.getText().toString();
                String passwordText = passwordField.getText().toString();

                if ( !userText.isEmpty()){

                    if ( !emailText.isEmpty()){

                        if ( !passwordText.isEmpty()){

                            user = new User();
                            user.setUsername(userText);
                            user.setEmail(emailText);
                            user.setPassword(passwordText);
                            Register(user);

                        }else {

                            Toast.makeText(RegisterActivity.this,
                                    "Password Missing!",
                                    Toast.LENGTH_SHORT).show();

                        }

                    }else {

                        Toast.makeText(RegisterActivity.this,
                                "Email Missing!",
                                Toast.LENGTH_SHORT).show();

                    }

                }else {

                    Toast.makeText(RegisterActivity.this,
                            "Username Missing!",
                            Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    // Method responsible for registering users with email and password and
    // make validations when making the registration
    public void Register(User user){

        auth = DatabaseConfig.getDatabaseAuth();
        auth.createUserWithEmailAndPassword(

                user.getEmail(),
                user.getPassword()

        ).addOnCompleteListener(

                this,
                new OnCompleteListener<AuthResult>(){

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task){

                        if (task.isSucessful()){

                            Toast.makeText(RegisterActivity.this,
                                    "Successfully Registered",
                                    Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();

                        }else{



                        }

                    }

                }

    }
        );

}

    public void inicializeComponents(){

        userField = findViewById(R.id.enterUsernameRegister);
        emailField = findViewById(R.id.enterEmailRegister);
        passwordField = findViewById(R.id.enterPasswordRegister);
        signInButton = findViewById(R.id.SignUpButton);

    }

}