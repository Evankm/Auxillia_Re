package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VendorActivity extends AppCompatActivity
{
    //declaring fields and buttons
    private TextView tView;
    private Button vendorBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);


        //linking variables to buttons & text
        tView = findViewById(R.id.tView);
        vendorBttn = findViewById(R.id.vendorBttn);

        vendorBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tView.setText("We will be arriving soon to pick up food!");

                final ProgressDialog pausingDialog = ProgressDialog.show(VendorActivity.this, "", "Loading..", true);
                new Thread() {
                    public void run() {
                        try {
                            Thread.sleep(10000); // The length to 'pause' for
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        pausingDialog.dismiss();
                    }
                }.start();

                toLogin();
            }
        });
    }
        //sends user to login page
        private void toLogin()
        {
            Intent loginIntent = new Intent (VendorActivity.this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }
}
