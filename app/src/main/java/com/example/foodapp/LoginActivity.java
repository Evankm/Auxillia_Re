package com.example.foodapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity
{
    //declaring fields and buttons
    private EditText loginEmailText;
    private Button loginBttn, loginRegBttn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //linking variables to buttons & text
        loginEmailText = findViewById(R.id.loginEmail);
        loginBttn = findViewById(R.id.loginBttn);
        loginRegBttn = findViewById(R.id.loginRegBttn);

        // on click triggers register method to send user to register page
        loginRegBttn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Register();
            }
        });

    }

    //sends user to register page
    private void Register()
    {
        Intent registerIntent = new Intent (LoginActivity.this, RegisterActivity.class);
        startActivity(registerIntent);
        finish();
    }
}