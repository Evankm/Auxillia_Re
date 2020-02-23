package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity
{
    //declaring fields and buttons
    private EditText loginEmailText, loginPassText;
    private Button loginBttn, loginRegBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        //linking variables to buttons & text
        loginEmailText = findViewById(R.id.loginEmail);
        loginPassText = findViewById(R.id.loginPass);
        loginBttn = findViewById(R.id.loginBttn);
        loginRegBtn = findViewById(R.id.loginRegBttn);

        // on click triggers register method to send user to register page
        loginRegBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Register();
            }
        });

        // on click triggers login method to send user to select page
        loginBttn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // string input fields
                final String loginEmail = loginEmailText.getText().toString();
                String loginPassword = loginPassText.getText().toString();

                //login logic
                if (!TextUtils.isEmpty(loginEmail) && !TextUtils.isEmpty(loginPassword))
                {
                    mAuth.signInWithEmailAndPassword(loginEmail,loginEmail).
                            addOnCompleteListener(new OnCompleteListener<AuthResult>()
                            {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task)
                                {
                                    if(task.isSuccessful())
                                    {
                                        Login();
                                    }else
                                    {
                                        // Display an error message so sorry
                                    }
                                }
                            });
                }}});
    }

    //sends user to select page
    private void Login()
    {
        Intent loginIntent = new Intent (LoginActivity.this, VVPActivity.class);
        startActivity(loginIntent);
        finish();
    }

    //sends user to register page
    private void Register()
    {
        Intent registerIntent = new Intent (LoginActivity.this, RegisterActivity.class);
        startActivity(registerIntent);
        finish();
    }


}