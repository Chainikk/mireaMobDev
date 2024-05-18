package com.example.myapplication11.DATA.DataSources.Room.Entities;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.room.Entity;
@Entity
public class DayEntity {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "Day")
    public String dayName;
    @ColumnInfo(name = "Description")
    public String description;
}
