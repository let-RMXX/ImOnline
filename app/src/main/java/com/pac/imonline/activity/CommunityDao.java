package com.pac.imonline.activity;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CommunityDao {
    @Insert
    void insert(Community community);

    @Query("SELECT * FROM communities")
    List<Community> getAllCommunities();

}

