package com.example.myapplication11.UI.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.myapplication11.R;
import com.example.myapplication11.UI.ViewModel.ItemDataViewModel;
import com.example.myapplication11.UI.ViewModel.ItemViewModel;

import android.os.Bundle;

public class ItemProfile extends Fragment {
    private ItemDataViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_itemprofile, container, false);
        viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity()
                        .getApplication())).get(ItemDataViewModel.class);
        String itemId = getArguments().getString("itemId");
        viewModel.getItem(itemId).observe(getViewLifecycleOwner(), item -> {
            if (item != null) {
                TextView itemName = view.findViewById(R.id.text_view);
                ImageView itemImage = view.findViewById(R.id.image_view);
                TextView description = view.findViewById(R.id.description);
                itemName.setText(item.getText());
                itemImage.setImageResource(item.getImageResource());
                description.setText("Время пробуждения: 7-00");
            }
        });
        view.findViewById(R.id.return_to_recycler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.from_item_to_recycler);
            }
        });
        return view;
    }
}
