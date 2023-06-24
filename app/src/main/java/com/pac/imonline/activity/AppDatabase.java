package com.pac.imonline.activity;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {EducationActivity.class, ProfileActivity.class, WorkActivity.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {
    public abstract ProfileDAO getProfileDAO();
    public abstract EducationDAO getEducationDAO();
    public abstract WorkDAO getWorkDAO();
    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "appBD").allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            //db.execSQL("Insert INTO chat VALUES(1, 'ChatRoom 1', 'res/drawable/chat_icon.png')");
                            // db.execSQL("Insert INTO message VALUES(1, 'OLÁ','res/drawable/chat_icon.png', 'Bot')");
                        }

                    })
                    .build();
        }

        return INSTANCE;
    }

}