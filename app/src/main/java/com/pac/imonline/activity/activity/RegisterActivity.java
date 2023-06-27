package com.pac.imonline.activity.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pac.imonline.R;

public class RegisterActivity extends AppCompatActivity {

    EditText enterUsernameRegister, enterEmailRegister, enterPasswordRegister;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        enterUsernameRegister = findViewById(R.id.enterUsernameRegister);
        enterEmailRegister = findViewById(R.id.enterEmailRegister);
        enterPasswordRegister = findViewById(R.id.enterPasswordRegister);
        signUpButton = findViewById(R.id.signUpButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(enterUsernameRegister.getText().toString());
                userEntity.setEmail(enterEmailRegister.getText().toString());
                userEntity.setPassword(enterPasswordRegister.getText().toString());
                if (validateInput(userEntity)){

                    AppDatabase appDatabase = AppDatabase.getAppDatabase(getApplicationContext());
                    final UserDao userDao = appDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User Successfully Registered!", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();

                } else {
                    Toast.makeText(getApplicationContext(), "Fill All Fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Boolean validateInput(UserEntity userEntity) {
        if (userEntity.getUsername().isEmpty() ||
        userEntity.getEmail().isEmpty() ||
        userEntity.getPassword().isEmpty()) {
            return false;
        }
        return true;
    }
}
