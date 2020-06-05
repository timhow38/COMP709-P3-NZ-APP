package com.example.mobileappc3;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CarvingDao {

    @Insert
    long[] insertCarvings(Carving... carvings);

    @Query("SELECT * FROM carvings")
    LiveData<List<Carving>> getCarvings();

    @Delete
    int deleteCarvings(Carving... carvings);

    @Update
    int updateCarvings(Carving... carvings);
}
