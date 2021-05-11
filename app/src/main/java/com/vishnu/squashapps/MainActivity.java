package com.vishnu.squashapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView, recyclerView1;
    LinearLayout lL_videos, lL_liked;
    ImageView imgVw_morePopUp, img_back;
    ItemListAdapter itemListAdapter;
    ItemListSecondAdapter itemListSecondAdapter;
    private List<ItemList> itemList = new ArrayList<>();
    private List<ItemListSecond> itemListTwo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgVw_morePopUp = findViewById(R.id.imgVw_morePopUp);
        imgVw_morePopUp.setOnClickListener(this);

        img_back = findViewById(R.id.img_back);
        img_back.setOnClickListener(this);

        lL_videos = findViewById(R.id.lL_videos);
        lL_videos.setOnClickListener(this);
        lL_liked = findViewById(R.id.lL_liked);
        lL_liked.setOnClickListener(this);


        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView1 = findViewById(R.id.recyclerView1);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView1.setLayoutManager(linearLayoutManager1);

        setItemList();

        setItemList2();


    }


    private void setItemList() {

        ItemList item = new ItemList(R.drawable.image1,"15.2K");
        itemList.add(item);
        item = new ItemList(R.drawable.image2,"1000");
        itemList.add(item);
        item = new ItemList(R.drawable.image3,"8546");
        itemList.add(item);

        itemListAdapter = new ItemListAdapter(getApplicationContext(), itemList);
        recyclerView.setAdapter(itemListAdapter);

    }

    private void setItemList2() {

        ItemListSecond itemTwo =  new ItemListSecond(R.drawable.image4);
        itemListTwo.add(itemTwo);
        itemTwo =  new ItemListSecond(R.drawable.image5);
        itemListTwo.add(itemTwo);
        itemTwo =  new ItemListSecond(R.drawable.image6);
        itemListTwo.add(itemTwo);

        itemListSecondAdapter = new ItemListSecondAdapter(getApplicationContext(),itemListTwo);
        recyclerView1.setAdapter(itemListSecondAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgVw_morePopUp:
                showPopup(imgVw_morePopUp);
                break;

            case R.id.lL_videos:
                lL_liked.setAlpha((float) 0.3);
                lL_videos.setAlpha(1);
                break;

            case R.id.lL_liked:
                lL_liked.setAlpha(1);
                lL_videos.setAlpha((float) 0.3);
                break;

            case R.id.img_back:
                finish();
                break;

            default:
                break;
        }
    }

    private void showPopup(View v) {

        Context wrapper = new ContextThemeWrapper(this,R.style.ThemeOverlay_MyTheme);
        PopupMenu popup = new PopupMenu(wrapper, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_actions, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        popup.show();
    }
}