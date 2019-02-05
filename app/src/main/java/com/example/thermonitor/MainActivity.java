package com.example.thermonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

   private EditText E_Mail;
   private EditText Password;
   private Button Login;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        E_Mail=(EditText)findViewById(R.id.etMail);
        Password=(EditText)findViewById(R.id.etPassword);
        Login=(Button)findViewById(R.id.etLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();

            }
        });
   }
   public void openSecondActivity(){
       Intent intent= new Intent(MainActivity.this,SecondActivity.class);
       startActivity(intent);
   }
}
