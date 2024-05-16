package com.example.myapplication11.UI.ViewModel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication11.DATA.Model.FragmentNavigateData;

public class FragmentNavigateDataViewModel extends ViewModel {
    private MutableLiveData<FragmentNavigateData> data = new MutableLiveData<>();
    public FragmentNavigateDataViewModel() {
        data.setValue(new FragmentNavigateData());
    }
    public MutableLiveData<FragmentNavigateData> getData() {
        return data;
    }

}
