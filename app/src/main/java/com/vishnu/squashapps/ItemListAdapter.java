package com.vishnu.squashapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.MyViewHolder> {

    private  Context context;
    List<ItemList> itemList = new ArrayList<>();
    ItemList itemData;

    public ItemListAdapter(Context context, List<ItemList> itemList) {

        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_itemadapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.MyViewHolder holder, int position) {

        itemData = itemList.get(position);

        holder.imgVw.setImageResource(itemData.getImageId());
        holder.txtVw_count.setText(itemData.getTitle());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgVw;
        public TextView txtVw_count;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgVw = itemView.findViewById(R.id.imgVw);
            txtVw_count = itemView.findViewById(R.id.txtVw_count);
        }
    }
}
