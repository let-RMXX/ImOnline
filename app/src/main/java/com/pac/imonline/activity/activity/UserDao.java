package com.pac.imonline.activity.activity;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    long registerUser(User user);

    @Query("SELECT * FROM users WHERE username = :username AND password = :password LIMIT 1")
    User loginUser(String username, String password);

    @Query("SELECT * FROM users")
    LiveData<List<User>> getAllUsers();
}
