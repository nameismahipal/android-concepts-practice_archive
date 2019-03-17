package com.example.android.recycleviewbasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Data Source
        ArrayList<DataModel> items = new ArrayList<DataModel>();

        items.add(new DataModel("Android 8.1", "Called Oreo", R.drawable.ic_portrait_black_48dp));
        items.add(new DataModel("Android 8", "Called Oreo", R.drawable.ic_portrait_black_48dp));
        items.add(new DataModel("Android 7.1", "Called Nougat", R.drawable.ic_portrait_black_48dp));
        items.add(new DataModel("Android 7", "Called Nougat", R.drawable.ic_portrait_black_48dp));

        items.add(new DataModel("Android 6", "Called Marshmallow", R.drawable.ic_portrait_black_48dp));
        items.add(new DataModel("Android 5.1", "Called Lollipop", R.drawable.ic_portrait_black_48dp));
        items.add(new DataModel("Android 5", "Called Lollipop", R.drawable.ic_portrait_black_48dp));
        items.add(new DataModel("Android 4.4", "Called Kit Kat", R.drawable.ic_portrait_black_48dp));
        items.add(new DataModel("Android 4.3", "Called Jelly Bean", R.drawable.ic_portrait_black_48dp));
        items.add(new DataModel("Android 4.2", "Called Jelly Bean", R.drawable.ic_portrait_black_48dp));
        items.add(new DataModel("Android 4.1", "Called Jelly Bean", R.drawable.ic_portrait_black_48dp));
        items.add(new DataModel("Android 4.0", "Called IceCream Sandwich", R.drawable.ic_portrait_black_48dp));
        items.add(new DataModel("Android 2.3", "Called Gingerbread", R.drawable.ic_portrait_black_48dp));


        LinearLayoutManager lvManager = new LinearLayoutManager(this);
        RecyclerView recycleview2 = (RecyclerView) findViewById(R.id.recycleview2);
        recycleview2.setLayoutManager(lvManager);
        recycleview2.setHasFixedSize(true);

        DataAdapter itemsAdapter = new DataAdapter(items);
        recycleview2.setAdapter(itemsAdapter);


    }
}
