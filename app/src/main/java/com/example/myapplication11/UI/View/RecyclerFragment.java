package com.example.myapplication11.UI.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication11.DATA.Model.Item;
import com.example.myapplication11.R;
import com.example.myapplication11.UI.View.Adapters.RecycleAdapter;
import com.example.myapplication11.UI.ViewModel.ItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerFragment extends Fragment {
    private ItemViewModel viewModel;
    public RecyclerFragment() {
        super(R.layout.fragment_recycler);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        List<Item> listItems = new ArrayList<>();
        for(int i = 0; i < 200; i ++){
            String text = "Day " + (i + 1);
            listItems.add(new Item(R.drawable.clock, text));
        }
        RecycleAdapter adapter = new RecycleAdapter(getContext(), listItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity().getApplication())).get(ItemViewModel.class);
        viewModel.getItems().observe(getViewLifecycleOwner(), items -> {
            adapter.notifyDataSetChanged();
        });
        view.findViewById(R.id.returnFromRecycle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.from_recycler_to_start);
            }
        });
        assert getArguments() != null;
        String result = getArguments().getString("recyclerKey");
        Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
        return view;
    }
}