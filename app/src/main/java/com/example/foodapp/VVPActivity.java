package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
        volunBttn = findViewById(R.id.volunBttn);
        citizenBttn = findViewById(R.id.citizenBttn);

        backBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                toLogin();
            }
        });

        volunBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toVolun();
            }
        });

        citizenBttn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                toVendorMore();
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

    //sends user to volun page
    private void toVolun()
    {
        Intent volunIntent = new Intent (VVPActivity.this, MainActivity.class);
        startActivity(volunIntent);
        finish();
    }
    private void toVendorMore()
    {
        Intent venMoreIntent = new Intent (VVPActivity.this, VendorMoreActivity.class);
        startActivity(venMoreIntent);
        finish();
    }
}
