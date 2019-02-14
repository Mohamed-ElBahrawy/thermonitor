package com.example.thermonitor;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

   private EditText E_Mail;
   private EditText Password;
   private Button Login;
   private TextView Account;
   private Button SignUp;
   private FirebaseAuth firebaseAuth;


   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        E_Mail=(EditText)findViewById(R.id.etMail);
        Password=(EditText)findViewById(R.id.etPassword);
        Login=(Button)findViewById(R.id.etLogin);
       SignUp=(Button)findViewById(R.id.etSignup);
       Account=(TextView)findViewById(R.id.etAccount);
       firebaseAuth=FirebaseAuth.getInstance();


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(E_Mail.getText().toString())||(TextUtils.isEmpty(Password.getText().toString()))){
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
                else{
                    validate(E_Mail.getText().toString(), Password.getText().toString());
                }


            }
        });
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFourthActivity();
            }
        });
   }

    private void openFourthActivity() {
        Intent intent1= new Intent(MainActivity.this,FourthActivity.class);
        startActivity(intent1);
    }

   private void validate(final String username, final String userpassword){
       firebaseAuth.signInWithEmailAndPassword(username,userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()){
                   startActivity(new Intent(MainActivity.this,SecondActivity.class));
               }else{
                   Toast.makeText(MainActivity.this,"Login failed",Toast.LENGTH_SHORT).show();
               }

           }
       });

   }
}
