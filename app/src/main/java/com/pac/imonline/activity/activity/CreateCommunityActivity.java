package com.pac.imonline.activity.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pac.imonline.R;

public class CreateCommunityActivity extends AppCompatActivity {

    private static final int REQUEST_SELECT_GALLERY = 2;

    private EditText communityNameEditText;
    private ImageView photoImageView;
    private Button selectPhotoButton;
    private ImageView bannerImageView;
    private Button selectBannerButton;
    private Button createCommunityButton;

    private Uri selectedPhotoUri;
    private Uri selectedBannerUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_community);

        communityNameEditText = findViewById(R.id.communityNameEditText);
        photoImageView = findViewById(R.id.photoImageView);
        selectPhotoButton = findViewById(R.id.selectPhotoButton);
        bannerImageView = findViewById(R.id.bannerImageView);
        selectBannerButton = findViewById(R.id.selectBannerButton);
        createCommunityButton = findViewById(R.id.createCommunityButton);

        selectPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        selectBannerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        createCommunityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String communityName = communityNameEditText.getText().toString().trim();
                String photoUrl = selectedPhotoUri != null ? selectedPhotoUri.toString() : null;
                String bannerUrl = selectedBannerUri != null ? selectedBannerUri.toString() : null;

                Community community = new Community(communityName, photoUrl, bannerUrl);

                // Save the community to the database
                AppDatabase appDatabase = AppDatabase.getAppDatabase(CreateCommunityActivity.this);
                CommunityDao communityDao = appDatabase.getCommunityDao();
                communityDao.insertCommunity(community);

                Intent intent = new Intent(CreateCommunityActivity.this, CommunityListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_SELECT_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUEST_SELECT_GALLERY && data != null) {
            Uri selectedImageUri = data.getData();
            if (selectedPhotoUri == null) {
                selectedPhotoUri = selectedImageUri;
                photoImageView.setImageURI(selectedPhotoUri);
            } else if (selectedBannerUri == null) {
                selectedBannerUri = selectedImageUri;
                bannerImageView.setImageURI(selectedBannerUri);
            }
        }
    }
}
