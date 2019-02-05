package com.example.thermonitor;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ListView listView =(ListView)findViewById(R.id.list);
        String[] fruits = {"apple","guava","pineapple","watermelon"};


        ListAdapter myadapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruits);
        listView.setAdapter(myadapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent= new Intent(SecondActivity.this,ThirdActivity.class);
               startActivity(intent);
           }
       });
    }
}
