package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    //declaring fields and buttons
    private EditText regEmail, regPass, regConfirmPass;
    private Button regBttn, regLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //linking variables to buttons & text
        regLoginBtn = findViewById(R.id.currentUserBttn);

        // on click triggers toLogin method to send user to login page
        regLoginBtn.setOnClickListener(new View.OnClickListener()
        {
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
        Intent loginIntent = new Intent (RegisterActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }

    //sends user to select page
    private void Register()
    {
        Intent registerIntent = new Intent (RegisterActivity.this, VVPActivity.class);
        startActivity(registerIntent);
        finish();
    }

}
