package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DropOffActivity extends AppCompatActivity {

    private Button backBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_off);

        backBttn = findViewById(R.id.backbtn);
        backBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                toBack();
            }
        });
    }
    private void toBack()
    {
        Intent loginIntent = new Intent (DropOffActivity.this, VVPActivity.class);
        startActivity(loginIntent);
        finish();
    }
}
