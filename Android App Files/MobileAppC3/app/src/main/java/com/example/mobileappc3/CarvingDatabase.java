package com.example.mobileappc3;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Carving.class}, version = 1, exportSchema = false)
public abstract class CarvingDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "carving_db";

    private static CarvingDatabase instance;

    static CarvingDatabase getInstance(final Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    CarvingDatabase.class,
                    DATABASE_NAME
            ).build();
        }
        return instance;
    }

    public abstract CarvingDao getCarvingDao();
}