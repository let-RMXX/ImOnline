package com.pac.imonline.activity.activity;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Community.class, User.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "ImOnlineDB";
    private static AppDatabase instance;

    public abstract CommunityDao getCommunityDao();

    public abstract UserDao getUserDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
