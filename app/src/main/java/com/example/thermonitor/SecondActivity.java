package com.example.thermonitor;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    int[]Images={R.drawable.sql,R.drawable.javascript,R.drawable.java,R.drawable.javac,R.drawable.python,R.drawable.javacc};
    String[] Names = {"SQL","JAVA","JAVA SCRIPT","C#","PYTHON","C++"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ListView listView =(ListView) findViewById(R.id.list);
        CustomListView customListView=new CustomListView(this,Names,Images);
        listView.setAdapter(customListView);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent3= new Intent(SecondActivity.this,ThirdActivity.class);
               startActivity(intent3);
           }
       });

    }



}
