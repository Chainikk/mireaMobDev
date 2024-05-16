package com.example.myapplication11.DATA.DataSources;

import androidx.lifecycle.LiveData;
import com.example.myapplication11.DATA.Model.Item;
import java.util.List;

public interface DataSource {
    LiveData<List<Item>> getItems();
    LiveData<Item> getItem(int itemId);
}
