package com.example.ammarali.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        ArrayList<ListItem> listData = getListData();

        final ListView listView = (ListView) findViewById(R.id.custom_list);
        listView.setAdapter((ListAdapter) new CustomListAdapter(this, listData));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                ListItem listData = (ListItem) listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Selected :" + " " + listData, Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<ListItem> getListData() {
        ArrayList<ListItem> listMockData = new ArrayList<ListItem>();
        String[] images = getResources().getStringArray(R.array.images_array);
        String[] heading = getResources().getStringArray(R.array.heading_array);

        for (int i = 0; i < images.length; i++) {
            ListItem listData = new ListItem();
            listData.setUrl(images[i]);
            listData.setHeading(heading[i]);
            listData.setRandomText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.");
            listMockData.add(listData);
        }
        return listMockData;
    }
}
