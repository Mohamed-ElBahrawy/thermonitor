package com.example.thermonitor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class FourthActivity extends AppCompatActivity {

    private EditText FullName;
    private EditText UserName;
    private EditText Password1;
    private EditText confirmPassword;
    private Button SignIn;
    private TextView Haccount;
    private Button Register;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        FullName=(EditText)findViewById(R.id.etText1);
        UserName=(EditText)findViewById(R.id.etText2);
        Password1=(EditText)findViewById(R.id.etPassword1);
        confirmPassword=(EditText)findViewById(R.id.etpassword2);
        SignIn=(Button)findViewById(R.id.etbutton1);
        Register=(Button)findViewById(R.id.etbutton2);
        Haccount=(TextView)findViewById(R.id.etText3);
        firebaseAuth=FirebaseAuth.getInstance();


        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Validate()){
                    String  user_name=UserName.getText().toString().trim();
                    String user_password=Password1.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_name,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(FourthActivity.this, "Registration success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(FourthActivity.this,MainActivity.class));
                            }else{
                                Toast.makeText(FourthActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });



    }

    private Boolean Validate() {
        Boolean result=false;
        String fullname=FullName.getText().toString();
        String username=UserName.getText().toString();
        String password=Password1.getText().toString();
        String confirmpassword=confirmPassword.getText().toString();

        if(fullname.isEmpty()||username.isEmpty()||password.isEmpty()||confirmpassword.isEmpty()){
            Toast.makeText(FourthActivity.this,"please enter all details",Toast.LENGTH_SHORT).show();
        }else{
            result=true;
        }
        return result;
    }

    private void openMainActivity() {
        Intent intent2= new Intent(FourthActivity.this,MainActivity.class);
        startActivity(intent2);
    }
}
