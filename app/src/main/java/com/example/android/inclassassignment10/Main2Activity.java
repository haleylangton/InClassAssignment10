package com.example.android.inclassassignment10;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private FirebaseAuth mAuth;

    private String email;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        emailEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
    }

    public void login (View view){

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(Main2Activity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Main2Activity.this,task.getResult().getUser().getEmail()+"log in successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

        });
    }

    public void signUp (View view) {
        email = emailEditText.getText().toString();
        password = passwordEditText.getText().toString();

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(Main2Activity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Main2Activity.this,task.getResult().getUser().getEmail()+"sign up successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

        });
    }

}
