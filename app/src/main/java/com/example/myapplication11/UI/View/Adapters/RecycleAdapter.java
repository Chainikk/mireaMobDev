package com.example.myapplication11.UI.View.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication11.DATA.Model.Item;
import com.example.myapplication11.R;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private final LayoutInflater inflater;

    private final List<Item> items;

    public RecycleAdapter(Context context, List<Item> items) {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.imageView.setImageResource(item.getImageResource());
        holder.textView.setText(item.getText());
        holder.layout.setOnClickListener(v -> {
            int clickedPosition = holder.getAdapterPosition();
            Toast.makeText(v.getContext(), "Day " + (clickedPosition + 1), Toast.LENGTH_SHORT).show();
            Log.d("RecyclerView", "Day " + (clickedPosition + 1));
            Bundle bundle =  new Bundle();
            bundle.putString("itemId", item.getText());
            holder.itemView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.itemprofile, bundle));
        });
    }
    @Override
    public int getItemCount() {return items.size();}
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        ViewGroup layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewItem);
            textView = itemView.findViewById(R.id.textViewItem);
            layout = itemView.findViewById(R.id.item_container);
        }
    }
}

