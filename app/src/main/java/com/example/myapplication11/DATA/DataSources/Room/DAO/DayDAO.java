package com.example.myapplication11.DATA.DataSources.Room.DAO;

import android.icu.util.ULocale;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.example.myapplication11.DATA.Model.ItemData;
import com.example.myapplication11.DATA.DataSources.Room.Entities.DayEntity;

import java.util.ArrayList;
import java.util.List;
@Dao
public interface DayDAO {
    @Query("SELECT * FROM DayEntity")
    List<DayEntity> getAll();
    @Query("SELECT * FROM DayEntity WHERE Day LIKE :itemName")
    DayEntity getDayByName(String itemName);

    @Insert
    void insertAll(ArrayList<DayEntity> dayEntities);
    @Delete
    void delete(DayEntity productEntity);

    @Query("SELECT COUNT(*) FROM DayEntity")
    Integer countRecords();

    @Query("DELETE FROM DayEntity")
    int cleanTable();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DayEntity day);
}
