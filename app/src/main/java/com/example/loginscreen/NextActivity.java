package com.example.loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //Initializing component from the layout
        Button button = findViewById(R.id.button);

        //set button on click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Redirect login screen when logout button is clicked
                Intent intent = new Intent(NextActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
