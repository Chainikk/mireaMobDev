package com.example.myapplication11.UI.ViewModel;

import androidx.lifecycle.LiveData;

import com.example.myapplication11.DATA.DataSources.Room.DAO.DayDAO;
import com.example.myapplication11.DATA.DataSources.Room.Entities.DayEntity;

import java.util.List;

public class DayViewModel {
    private LiveData<List<DayEntity>> data;

    public LiveData<List<DayEntity>> getData(DayDAO dao) {
        if (data == null) {
            //data = dao.getAll();
        }
        return data;
    }
}
