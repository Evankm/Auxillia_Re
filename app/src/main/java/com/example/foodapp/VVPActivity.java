package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VVPActivity extends AppCompatActivity
{

    //declaring fields and buttons
    private Button vendorBttn, volunBttn, citizenBttn, backBttn, dropOffBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vvp);

        //linking variables to buttons & text
        backBttn = findViewById(R.id.backBttn);
        volunBttn = findViewById(R.id.volunBttn);
        citizenBttn = findViewById(R.id.citizenBttn2);
        dropOffBtn = findViewById(R.id.DropOff);
        vendorBttn = findViewById(R.id.vendorBttn);

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
        dropOffBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                toDropOff();
            }
        });
        vendorBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                toVendor();
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
    private void toDropOff()
    {
        Intent dropbOff = new Intent (VVPActivity.this, DropOffActivity.class);
        startActivity(dropbOff);
        finish();
    }
    //sends user to vendor page
    private void toVendor()
    {
        Intent venIntent = new Intent (VVPActivity.this, VendorActivity.class);
        startActivity(venIntent);
        finish();
    }
}
