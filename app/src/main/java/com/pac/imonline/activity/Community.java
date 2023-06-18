package com.pac.imonline.activity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "communities")
public class Community {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String photoUrl;
    private String bannerUrl;
    private boolean isOwner;

    public Community(String name, String photoUrl, String bannerUrl, boolean isOwner) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.bannerUrl = bannerUrl;
        this.isOwner = isOwner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public boolean isOwner() {
        return isOwner;
    }
}
