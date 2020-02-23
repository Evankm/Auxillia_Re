package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VVPActivity extends AppCompatActivity
{

    //declaring fields and buttons
    private Button vendorBttn, volunBttn, citizenBttn, logOutBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vvp);

        //linking variables to buttons & text
        logOutBttn = findViewById(R.id.logOutBttn);
        volunBttn = findViewById(R.id.volunBttn);
        citizenBttn = findViewById(R.id.citizenBttn);
        vendorBttn = findViewById(R.id.vendorBttn);

        logOutBttn.setOnClickListener(new View.OnClickListener() {
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
                toFood();
            }
        });

        vendorBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                toDonor();
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
    //sends user to food page
    private void toFood()
    {
        Intent venMoreIntent = new Intent (VVPActivity.this, VendorMoreActivity.class);
        startActivity(venMoreIntent);
        finish();
    }

    private void toDonor()
    {
        Intent donorIntent = new Intent (VVPActivity.this, DonorActivity.class);
        startActivity(donorIntent);
        finish();
    }
}
