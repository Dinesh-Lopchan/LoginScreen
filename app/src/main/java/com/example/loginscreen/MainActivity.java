package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    // Initializing and declaring UI with their respective elements
    EditText email, password;
    TextView attempt;
    Button submit, clear;

    // Initializing variables
    String username, inputpassword;
    int Attempts = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing the IDs
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        attempt = findViewById(R.id.attempt);
        submit = findViewById(R.id.submit);
        clear = findViewById(R.id.clear);

        // Add text change listeners to the email EditText
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                // input username
                username = s.toString();

                // verify the username length
                if (username.length() < 4) {
                    email.setError("Username must be at least 4 characters");
                } else {
                    email.setError(null);
                }
            }
        });

        // Add text change listeners to the password EditText
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                // input password
                inputpassword = s.toString();

                // Verify the password length
                if (password.length() < 4) {
                    password.setError("Password must be at least 4 characters");
                } else {
                    password.setError(null);
                }
            }

        });

        // Set remaining attempts
        attempt.setText("Remaining attempts: " + Attempts);


        // submit button click listener for authentication
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.equals("admin") &&
                        inputpassword.equals("admin")) {

                    // Redirect to the  Next activity if the inputs are correct
                    startActivity(new Intent(MainActivity.this, NextActivity.class));
                } else {

                    // number of attempts decreases on wrong input
                    Attempts--;
                    attempt.setText("Remaining attempts: " + Attempts);

                    // Disable submit button after remaining attempts becomes zero exiting the app
                    if (Attempts == 0) {
                        submit.setEnabled(false);
                        finish();
                    }
                }
            }
        });

        // Clear button click listener to reset username, password and remaining attempts
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.setText("");
                password.setText("");
                attempt.setText("Remaining attempts: " + Attempts);
                submit.setEnabled(true);
            }
        });
    }
}