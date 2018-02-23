package com.example.android.quizapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;


public class ActivityTwo extends AppCompatActivity {
    ProgressBar mProgressBar;                       //Declare ProgressBar
    CountDownTimer mCountDownTimer;                 //CountDownTimer to apply to ProgressBar
    int i = 0;                                      //Tick variable for CountDownTimer
    int num = 0;                                    //Current Fragment number
    int score = 0;                                  //Total score : Questions answered correctly

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        continueLayout();
    }


    /*
     *  Sets up the Progress Bar with the CountDown Timer
     *  countDownSetup()
     *  returns : void
     *
     *  - CountDownTimer is currently for: 15s, with intervals of 30ms
     *  - On finish, calls the next Fragment via ChangeFragment();
     */

    public void countDownSetup() {
        i = 0;
        mProgressBar = findViewById(R.id.progressbar);
        mProgressBar.setProgress(100);
        mCountDownTimer = new CountDownTimer(15000, 30) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress" + i + millisUntilFinished);
                i++;
                mProgressBar.setProgress(100 - (i * 100 / (15000 / 34)));

            }

            @Override
            public void onFinish() {
                //Do what you want
                i++;
                mProgressBar.setProgress(100);
                ChangeFragment(null);


            }
        };
        mCountDownTimer.start();
    }


    /*
     *  Refreshes CountDownTimer, switches Fragments, and upon completion, activates the next Activity
     *  ChangeFragment(View view)
     *  returns : void
     */


    public void ChangeFragment(View view) {
        Fragment fragment;
        removeAnswerScreen();


        if (num >= 1) {
            mCountDownTimer.cancel();
        }

        num++;

        if (num > 7) {
            scoreActivity();
        }

        if (num <= 7) {
            fragment = nextFragment(num);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            //ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
            countDownSetup();
        }


    }

    /*
     * Switch statement for calling each Fragment
     * nextFragment(int i)
     * returns : Fragment via case(i)
     */

    public Fragment nextFragment(int i) {
        Fragment fragment = new Fragment();

        switch (i) {

            case 0:
                fragment = new IntroFragment();
                break;

            case 1:
                fragment = new FragmentOne();
                break;

            case 2:
                fragment = new FragmentTwo();
                break;

            case 3:
                fragment = new FragmentThree();
                break;

            case 4:
                fragment = new FragmentFour();
                break;

            case 5:
                fragment = new FragmentFive();
                break;

            case 6:
                fragment = new FragmentSix();
                break;

            case 7:
                fragment = new FragmentSeven();
                break;

            default:
                return null;
        }
        return fragment;
    }

    /*
     * Sets current layout to question_layout when continue_button is clicked
     * Also pushes name userInput from name_field to the question_layout
     * continueLayout()
     * returns : void
     */

    public void continueLayout() {
        Button button = findViewById(R.id.continue_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = findViewById(R.id.name_field);
                String name = input.getText().toString();
                setContentView(R.layout.question_layout);
                TextView nameTop = findViewById(R.id.name_at_top);
                nameTop.setText(name);
            }
        });
    }

    /*
     * Sets correctScreen || wrongScreen back to invisible
     * removeAnswerScreen()
     * returns : void
     */

    public void removeAnswerScreen() {
        TextView correctScreen = findViewById(R.id.correct);
        TextView wrongScreen = findViewById(R.id.wrong);
        if (correctScreen.getVisibility() == View.VISIBLE) {
            correctScreen.setVisibility(View.INVISIBLE);
        }
        if (wrongScreen.getVisibility() == View.VISIBLE) {
            wrongScreen.setVisibility(View.INVISIBLE);
        }

    }

    /*
     * Cancels countDownTimer
     * cancelTimer()
     * returns : void
     */

    public void cancelTimer() {
        mCountDownTimer.cancel();
    }

    /*
     * Creates Intent to pass name, score, and totalScore variables to ScoreActivity. Starts ScoreActivity
     * scoreActivity()
     * returns : void
     */

    public void scoreActivity() {
        Intent mIntent = new Intent(ActivityTwo.this, ScoreActivity.class);
        TextView input = findViewById(R.id.name_at_top);
        String name = input.getText().toString();
        double totalScore = calculateScore();
        mIntent.putExtra("totalScore", totalScore);
        mIntent.putExtra("correctAnswers", score);
        mIntent.putExtra("name", name);
        startActivity(mIntent);
    }

    /*
     * Adds 1 point to score
     * addToScore()
     * returns : void
     */

    public void addToScore() {
        score++;
    }

    /*
     * Calculates score in percentage based on how many questions answered correctly
     * calculateScore()
     * returns : double
     */

    public double calculateScore() {
        return (score / 7.0) * 100;
    }
}
