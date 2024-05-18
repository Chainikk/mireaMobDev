package com.example.myapplication11.DATA.DataSources.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.myapplication11.DATA.DataSources.Room.DAO.DayDAO;
import com.example.myapplication11.DATA.DataSources.Room.Entities.DayEntity;

import java.util.List;

@Database(entities = {DayEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "List";
    public abstract DayDAO listDAO();
}