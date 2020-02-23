package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DonorActivity extends AppCompatActivity {

    //declaring fields and buttons
    Button foodbtn, close, logout;
    TextView pick;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);

        //linking variables to buttons & text
        foodbtn = findViewById(R.id.foodBttn);
        pick = findViewById(R.id.pickupText);
        close = findViewById(R.id.closeBttn);
        logout = findViewById(R.id.logOutBttn);

        foodbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                pick.setText("Food is available for pick up");
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Exit();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                LogOut();
            }
        });

    }

    //close app
    private void Exit()
    {
        finish();
        System.exit(0);
    }

    //sends user to login page
    private void LogOut()
    {
        Intent VVPIntent = new Intent (DonorActivity.this, LoginActivity.class);
        startActivity(VVPIntent);
        finish();
    }
}
