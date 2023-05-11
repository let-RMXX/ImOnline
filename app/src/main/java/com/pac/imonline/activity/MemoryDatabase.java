package com.pac.imonline.activity;

import java.util.ArrayList;
import java.util.List;

public class MemoryDatabase {

    private static List<ProfileActivity2> profile;

    private static List<ProfileActivity2> initializeList() {
        if (profile == null){
            profile = new ArrayList<>();
            profile.add(new ProfileActivity2(1, "https://www.w3schools.com/howto/img_avatar.png", "Carlos Álvaro", "Student", "963951139", "carlosa@outlook.pt","Beja"));

        }
        return profile;
    }
    public static List<ProfileActivity2> getAllContacts() {
        return initializeList();
    }

    public static ProfileActivity2 getContactForPosition(int position) {
        return initializeList().get(position);
    }
}
