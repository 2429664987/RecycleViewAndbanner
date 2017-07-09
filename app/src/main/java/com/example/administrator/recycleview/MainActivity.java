package com.example.administrator.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.recycleview.Adapters.RecycleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> banner_url;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner_url=new ArrayList<>();
        banner_url.add("http://192.168.43.246:8080/travel/imgs/banners/banner1.jpg");
        banner_url.add("http://192.168.43.246:8080/travel/imgs/banners/banner2.jpg");
        banner_url.add("http://192.168.43.246:8080/travel/imgs/banners/banner3.jpg");
        banner_url.add("http://192.168.43.246:8080/travel/imgs/banners/banner4.jpg");
        mRecyclerView= (RecyclerView) findViewById(R.id.recycler_view);


        RecycleAdapter recycleAdapter=new RecycleAdapter(this,banner_url);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(recycleAdapter);
    }
}
