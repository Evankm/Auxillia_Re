package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class donorActivity extends AppCompatActivity {

    //declaring fields and buttons
    Button foodbtn, close;
    TextView pick;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);

        //linking variables to buttons & text
        foodbtn = findViewById(R.id.foodBttn);
        pick = findViewById(R.id.pickupText);

        foodbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pick.setText("Food is available for pick up");
            }
        });
    }
}
