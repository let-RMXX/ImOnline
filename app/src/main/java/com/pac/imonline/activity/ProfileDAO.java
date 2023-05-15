package com.pac.imonline.activity;

import androidx.room.Query;

import java.util.List;

public interface ProfileDAO {

    @Query("SELECT * FROM ProfileActivity2")
    List<ProfileActivity2> getAll();

}
