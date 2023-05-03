package com.pac.imonline.activity;

import java.util.ArrayList;
import java.util.List;

public class MemoryDatabase {

    private static List<ProfileActivity2> profile;

    private static List<ProfileActivity2> initializeList() {
        if (profile == null){
            profile = new ArrayList<>();
            profile.add(new ProfileActivity2("Calos", "963951139","https://w7.pngwing.com/pngs/643/454/png-transparent-business-game-avatar-computer-program-google-smart-object-game-child-face.png"));

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
