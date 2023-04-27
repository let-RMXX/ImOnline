package com.pac.imonline.activity;

public class ProfileActivity2 {
    private String name;
    private String phoneNumber;
    private String avatar;


    public ProfileActivity2(String name, String phoneNumber, String avatar){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }
}
