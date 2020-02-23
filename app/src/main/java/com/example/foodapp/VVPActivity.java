package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VVPActivity extends AppCompatActivity
{

    //declaring fields and buttons
    private Button vendorBttn, volunBttn, citizenBttn, backBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vvp);

        //linking variables to buttons & text
        backBttn = findViewById(R.id.backBttn);

        backBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                toLogin();
            }
        });
    }


    //sends user to login page
    private void toLogin()
    {
        Intent loginIntent = new Intent (VVPActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }
}
