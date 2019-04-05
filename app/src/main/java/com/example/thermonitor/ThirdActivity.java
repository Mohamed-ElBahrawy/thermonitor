package com.example.thermonitor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ThirdActivity extends AppCompatActivity {
    private int ValueEsp;
    FirebaseDatabase database;
    DatabaseReference myRef;
    private EditText Temp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference(SecondActivity.Esp);
        Temp=findViewById(R.id.edit_text_Temp);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        FirebaseApp.getApps(this);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int value=dataSnapshot.getValue(Integer.class);
                Temp.setText(value);
                Log.v("Temp","Esp1: " +value );

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed to read error" , databaseError.toException());

            }
        });

    }
}
