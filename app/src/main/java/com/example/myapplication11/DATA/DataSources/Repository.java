package com.example.myapplication11.DATA.DataSources;

import androidx.lifecycle.LiveData;

import com.example.myapplication11.DATA.Model.Item;

import java.util.List;

public class Repository {
    private DataSource dataSource = new LocalDataSource();
    public LiveData<List<Item>> getItems() {
        return dataSource.getItems();
    }
    public LiveData<Item> getItem(int itemId) {
        return dataSource.getItem(itemId);
    }
}
