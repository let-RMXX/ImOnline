package com.pac.imonline.activity.activity;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {
    private UserDao userDao;

    public UserRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        userDao = database.getUserDao();
    }

    public long registerUser(User user) {
        return userDao.registerUser(user);
    }

    public User loginUser(String username, String password) {
        return userDao.loginUser(username, password);
    }

    public LiveData<List<User>> getAllUsers() {
        return userDao.getAllUsers();
    }
}
