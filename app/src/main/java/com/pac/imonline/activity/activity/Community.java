package com.pac.imonline.activity.activity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "communities")
public class Community {

    @PrimaryKey(autoGenerate = true)
    Integer id;
    String name;
    String photoUrl;
    String bannerUrl;

    public Community(String name, String photoUrl, String bannerUrl) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.bannerUrl = bannerUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
