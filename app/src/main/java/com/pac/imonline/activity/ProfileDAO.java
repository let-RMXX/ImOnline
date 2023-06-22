package com.pac.imonline.activity;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface ProfileDAO {

    @Query("SELECT * FROM profileactivity")
    List<ProfileActivity> getAll();

    @Query("SELECT * FROM profileactivity WHERE id = profileId")
    ProfileActivity getById(long profileId);

    @Insert
    void insert ( ProfileActivity profileActivity);

    @Insert
    void insert (List<ProfileActivity> profileActivityList);

    @Update
    void update(ProfileActivity profileActivity);

    @Delete
    void delete(ProfileActivity profileActivity);


}
