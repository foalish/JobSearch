package com.example.david.notconstraint_layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String android_image_urls[] = {
            "http://davidfoale.info/images/app_images/vetsurgeon.jpg",
            "http://davidfoale.info/images/app_images/hairdresser.jpg",
            "http://davidfoale.info/images/app_images/vetsurgeon.jpg",
            "http://davidfoale.info/images/app_images/hairdresser.jpg",
            "http://davidfoale.info/images/app_images/vetsurgeon.jpg",
            "http://davidfoale.info/images/app_images/hairdresser.jpg",
            "http://davidfoale.info/images/app_images/vetsurgeon.jpg",
            "http://davidfoale.info/images/app_images/hairdresser.jpg",
            "http://davidfoale.info/images/app_images/vetsurgeon.jpg",
            "http://davidfoale.info/images/app_images/hairdresser.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }



    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(), androidVersions);
        recyclerView.setAdapter(adapter);
    }



    private ArrayList prepareData() {

        ArrayList android_version = new ArrayList<>();
        for (int i = 0; i < android_image_urls.length; i++) {
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }
}
