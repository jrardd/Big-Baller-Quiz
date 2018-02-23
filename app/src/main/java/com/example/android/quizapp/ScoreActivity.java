package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Bundle b = getIntent().getExtras();                          //Data from previous Activity
        DecimalFormat df2 = new DecimalFormat(".#");         //Formats double to one decimal place
        double totalScore = b.getDouble("totalScore");          //Total Score
        int questionsAnswered = b.getInt("correctAnswers");     //Amount of questions answered correctly
        String nameInput = b.getString("name");                 //Name input
        TextView name = findViewById(R.id.name);                     //TextView to display name on Score Screen

        name.setText(nameInput);
        TextView finalScore = findViewById(R.id.finalScore);
        String scoreValue = String.valueOf(df2.format(totalScore));
        finalScore.setText(scoreValue + "%");

    }

     /*
     * "Resets" Application by returning to MainActivity when called
     * reset(View view)
     * returns : void
     */

    public void reset(View view) {
        Intent i = new Intent(ScoreActivity.this, MainActivity.class);
        startActivity(i);
    }


}
