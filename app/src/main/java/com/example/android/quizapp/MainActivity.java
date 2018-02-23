package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureContinueButton();

    }

    /*
     * Sets current activity from MainActivity to ActivityTwo by clicking continue_button
     * configureContinueButton()
     * returns : void
     */

    private void configureContinueButton() {
        Button continueButton = findViewById(R.id.continue_button);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityTwo.class));
            }
        });
    }

}
