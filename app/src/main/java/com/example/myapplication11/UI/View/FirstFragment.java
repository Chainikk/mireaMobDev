package com.example.myapplication11.UI.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myapplication11.DATA.Model.FragmentNavigateData;
import com.example.myapplication11.R;

public class FirstFragment extends Fragment {
    public FragmentNavigateData data = new FragmentNavigateData();
    public FirstFragment() {
        super(R.layout.fragment_first);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        view.findViewById(R.id.toStartFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.from_first_to_start);
            }
        });
        return view;
    }
}
