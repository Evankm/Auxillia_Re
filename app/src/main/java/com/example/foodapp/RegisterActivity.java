package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    //declaring fields and buttons
    private EditText regEmail, regPass, regConfirmPass;
    private Button regBtn, regLoginBtn;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        //linking variables to buttons & text
        regLoginBtn = findViewById(R.id.currentUserBttn);
        regEmail = findViewById(R.id.regEmail);
        regPass = findViewById(R.id.regPass);
        regConfirmPass = findViewById(R.id.regConfirmPass);
        regBtn = findViewById(R.id.regBttn);

        // on click triggers toLogin method to send user to login page
        regBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Register();
            }
        });

        // registering on button click
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // grabbing fields and turning them to strings
                final String email = regEmail.getText().toString();
                String pass = regPass.getText().toString();
                String confirmPass = regConfirmPass.getText().toString();

                // checking to make sure all fields are populated and passwords match
                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)
                        && !TextUtils.isEmpty(confirmPass))
                // if passwords match create user
                {if (pass.equals(confirmPass)){
                    mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if(task.isSuccessful())
                            {
                                Register();
                            }
                            else
                                {
                                String errorMessage = task.getException().getMessage();
                                Toast.makeText(RegisterActivity.this, "Error: " + errorMessage , Toast.LENGTH_LONG).show();
                                }}});
                    } else {
                    Toast.makeText(RegisterActivity.this, "Confirm Password and Password field match!", Toast.LENGTH_LONG).show();
                } } }});

    }



    //sends user to select page
    private void Register()
    {
        Intent registerIntent = new Intent (RegisterActivity.this, VVPActivity.class);
        startActivity(registerIntent);
        finish();
    }
}
