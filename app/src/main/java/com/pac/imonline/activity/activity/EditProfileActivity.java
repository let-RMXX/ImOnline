package com.pac.imonline.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.pac.imonline.R;
import com.pac.imonline.activity.ProfileActivity;

import java.util.List;

public class EditProfileActivity extends AppCompatActivity {

    ImageView imgViewAvatar;
    FloatingActionButton floatingActionButton;
    int[] avatarList;
    int position;
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

        imgViewAvatar = findViewById(R.id.imageViewAvatar);
        floatingActionButton = findViewById(R.id.imgbutton);
        avatarList = avatarList = new int[]{R.drawable.photo_1, R.drawable.photo_2,R.drawable.photo_3,R.drawable.photo_4,};
        position = 0;
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if (position >=avatarList.length){
                    position = 0;
                }
                imgViewAvatar.setImageResource(avatarList[position]);
            }
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        this.editTextName = findViewById(R.id.editTextName);
        this.editTextAbout = findViewById(R.id.editTextAbout);
        this.editTextPhone = findViewById(R.id.editTextPhone);
        this.editTextEmail = findViewById(R.id.editTextEmail);
        this.editTextLocation = findViewById(R.id.editTextLocation);
        this.imgViewAvatar = findViewById(R.id.imageViewAvatar);

    }

    public void editProfile(View view){
        String name = this.editTextName.getText().toString();
        String about = this.editTextAbout.getText().toString();
        String phone = this.editTextPhone.getText().toString();
        String email = this.editTextEmail.getText().toString();
        String location = this.editTextLocation.getText().toString();
        String avatar = Integer.toString(avatarList[position]);

        int profileId=1;

        ProfileActivity currentProfile = AppDatabase.getInstance(this).getProfileDAO().getById(profileId);

        if ((currentProfile != null)){
            currentProfile.updateProfile(name, about, phone, email, location, avatar);

            AppDatabase.getInstance(this).getProfileDAO().updateProfile(currentProfile);
            finish();
        } else {
            AppDatabase.getInstance(this).getProfileDAO().getById(profileId);
        }

    }
}