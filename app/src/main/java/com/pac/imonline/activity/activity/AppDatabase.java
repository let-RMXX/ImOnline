package com.pac.imonline.activity.activity;

import android.content.Context;


import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.pac.imonline.activity.activity.EducationActivity;
import com.pac.imonline.activity.activity.EducationDAO;
import com.pac.imonline.activity.activity.ProfileActivity;
import com.pac.imonline.activity.activity.ProfileDAO;
import com.pac.imonline.activity.activity.WorkActivity;
import com.pac.imonline.activity.activity.WorkDAO;

@Database(entities = {Community.class, UserEntity.class, EducationActivity.class, ProfileActivity.class, WorkActivity.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String dbName = "imonlinedb";
    private static AppDatabase appDatabase;
    private static AppDatabase INSTANCE;

    public static synchronized AppDatabase getAppDatabase(Context context){
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDatabase;
    }

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "imonlinedb").allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            db.execSQL("INSERT INTO profileActivity VALUES(1,'','name','about', 'phone', 'email', 'location')");
                        }

                    })
                    .build();
        }

        return INSTANCE;
    }

    public abstract UserDao userDao();

    public abstract CommunityDao getCommunityDao();

    public abstract ProfileDAO getProfileDAO();

    public abstract EducationDAO getEducationDAO();

    public abstract WorkDAO getWorkDAO();
}
