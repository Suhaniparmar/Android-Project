package com.example.codesynctest;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private TextView signupLink;
    DBHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher_logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("CodeSync");

        emailEditText = findViewById(R.id.email1);
        passwordEditText = findViewById(R.id.password1);
        loginButton = findViewById(R.id.login_button1);
        signupLink = findViewById(R.id.signupLink1);
        databaseHelper = new DBHelper(this);

        signupLink.setOnClickListener(v -> {
            Intent signupIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(signupIntent);
        });

        loginButton.setOnClickListener(v -> {
            String emailInput = emailEditText.getText().toString().trim();
            String passwordInput = passwordEditText.getText().toString().trim();

            if (databaseHelper.checkUser(emailInput, passwordInput)) {
                // Redirect to HomeActivity (or any other activity)
                Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(homeIntent);
            } else {
                Toast.makeText(LoginActivity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
