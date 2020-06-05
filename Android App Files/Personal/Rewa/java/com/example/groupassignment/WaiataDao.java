package com.example.groupassignment;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WaiataDao {
    @Insert
    long[]insertWaiata(Waiata... waiatas);

    @Query("SELECT * FROM waiata")
    LiveData<List<Waiata>> getWaiata();

    @Delete
    int deleteWaiata(Waiata... waiatas);

    @Update
    int updateWaiata(Waiata... waiatas);
}
