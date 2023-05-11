package com.pac.imonline.activity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ProfileActivity2 {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String avatar;
    private String name;
    private String about;
    private String phoneNumber;

    private String email;
    private String location;

    public ProfileActivity2(long id, String avatar, String name, String about, String phoneNumber,String email, String location)
    {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.about = about;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.location = location;
    }

    public long getId(){return id;}
    public String getAvatar() {
        return avatar;
    }
    public String getName() {
        return name;
    }
    public String getAbout() {
        return about;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail(){return email;}

    public String getLocation() {
        return location;
    }
}

