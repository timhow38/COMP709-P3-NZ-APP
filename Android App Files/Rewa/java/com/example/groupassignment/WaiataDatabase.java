package com.example.groupassignment;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Waiata.class}, version = 1)
public abstract class WaiataDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "waiata_db";

    private static WaiataDatabase instance;

    static WaiataDatabase getInstance(final Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    WaiataDatabase.class,
                    DATABASE_NAME
            ).build();
        }
        return  instance;
    }

    public abstract WaiataDao getWaiataDao();
}