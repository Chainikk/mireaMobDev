package com.example.myapplication11.UI.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication11.DATA.DataSources.Repository;
import com.example.myapplication11.DATA.Model.Item;
import com.example.myapplication11.DATA.Model.ItemData;
import com.example.myapplication11.R;

public class ItemDataViewModel extends ViewModel {
    private Repository repository = new Repository();
    public LiveData<Item> getItem(String itemId) {
        return new MutableLiveData<>(new Item(R.drawable.clock, itemId));
    }
}
