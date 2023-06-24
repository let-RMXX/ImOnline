package com.pac.imonline.activity;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface WorkDAO {
    @Query("SELECT * FROM WorkActivity")
    List<WorkActivity> getAll();

    @Query("SELECT * FROM WorkActivity WHERE id = workId")
    WorkActivity getById(long workId);

    @Insert
    void insert ( WorkActivity workActivity);

    @Insert
    void insert (List<WorkActivity> workActivityList);

    @Update
    void update(WorkActivity workActivity);

    @Delete
    void delete(WorkActivity workActivity);

}
