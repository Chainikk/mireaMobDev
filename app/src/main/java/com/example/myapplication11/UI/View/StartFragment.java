package com.example.myapplication11.UI.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication11.DATA.Model.FragmentNavigateData;
import com.example.myapplication11.R;

public class StartFragment extends Fragment {
    public FragmentNavigateData data = new FragmentNavigateData();
    public StartFragment() {
        super(R.layout.fragment_start);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        view.findViewById(R.id.toListFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String result = data.getDataFromStartToList();
                bundle.putString("listKey", result);
                Navigation.findNavController(v).navigate(R.id.from_start_to_list, bundle);
            }
        });

        view.findViewById(R.id.toRecyclerFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String result = data.getDataFromStartToRecycler();
                bundle.putString("recyclerKey", result);
                Navigation.findNavController(v).navigate(R.id.from_start_to_recycler, bundle);
            }
        });
        return view;
    }
}