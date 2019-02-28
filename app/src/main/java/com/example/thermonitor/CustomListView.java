/*package com.example.thermonitor;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class CustomListView extends ArrayAdapter<String> {
    private ArrayList<String>Names;
    private ArrayList<Integer>Images;
    private BroadcastReceiver context;


    public CustomListView(BroadcastReceiver context, ArrayList<String>Names, ArrayList<Integer>Images) {
        super(context, R.layout.activity_second,Names);
        this.context=context;
        this.Images=Images;
        this.Names=Names;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r == null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.languages,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);

        }else{
            viewHolder=(ViewHolder) r.getTag();


        }
        viewHolder.imageView1.setImageResource(Images.get(position));
        viewHolder.textView1.setText(Names.get(position));

        return r;
    }
    class ViewHolder{
        TextView textView1;
        ImageView imageView1;
        ViewHolder(View v){
            textView1=(TextView)v.findViewById(R.id.textView);
            imageView1=(ImageView)v.findViewById(R.id.imageView);

        }
    }
}
*/