package com.vishnu.squashapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemListSecondAdapter extends RecyclerView.Adapter<ItemListSecondAdapter.MyViewHolder> {

    private  Context context;
    List<ItemListSecond> itemList = new ArrayList<>();
    ItemListSecond itemData;

    public ItemListSecondAdapter(Context context, List<ItemListSecond> itemListTwo) {

        this.context = context;
        this.itemList = itemListTwo;
    }

    @NonNull
    @Override
    public ItemListSecondAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_itemsecondadapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListSecondAdapter.MyViewHolder holder, int position) {

        itemData = itemList.get(position);

        holder.imgVw.setImageResource(itemData.getImageId());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgVw;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgVw = itemView.findViewById(R.id.imgVw);

        }
    }
}
