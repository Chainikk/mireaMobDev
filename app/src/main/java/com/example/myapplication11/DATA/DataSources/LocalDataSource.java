package com.example.myapplication11.DATA.DataSources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication11.DATA.Model.Item;
import com.example.myapplication11.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalDataSource implements DataSource {
    private Map<Integer, Item> items = new HashMap<>();
    public LocalDataSource() {
        for (int i = 0; i < 200; i++) {
            String text = "Day " + (i + 1);
            items.put(R.drawable.clock, new Item(R.drawable.clock, text));
        }
    }
    @Override
    public LiveData<List<Item>> getItems() {
        MutableLiveData<List<Item>> liveData = new MutableLiveData<>();
        liveData.setValue(new ArrayList<>(items.values()));
        return liveData;
    }
    @Override
    public LiveData<Item> getItem(int itemId) {
        MutableLiveData<Item> liveData = new MutableLiveData<>();
        liveData.setValue(items.get(itemId));
        return liveData;
    }
}
