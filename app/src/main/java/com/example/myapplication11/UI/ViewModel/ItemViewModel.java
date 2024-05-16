package com.example.myapplication11.UI.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication11.DATA.DataSources.Repository;
import com.example.myapplication11.DATA.Model.Item;

import java.util.List;

public class ItemViewModel extends ViewModel {
    private Repository repository = new Repository();
    public LiveData<List<Item>> getItems() {
        return repository.getItems();
    }

}
