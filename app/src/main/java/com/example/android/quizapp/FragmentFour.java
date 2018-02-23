package com.example.android.quizapp;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FragmentFour extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment_four, container, false);

        final TextView correct = getActivity().findViewById(R.id.correct);
        final TextView wrong = getActivity().findViewById(R.id.wrong);
        final Button choice1 = view.findViewById(R.id.c1);
        final Button choice2 = view.findViewById(R.id.c2);
        final Button choice3 = view.findViewById(R.id.c3);
        final Button choice4 = view.findViewById(R.id.c4);

        /*
         * OnClickListeners for each button (Imitate RadioButton function)
         *
         * On click :
         * -Sets Green, sets CorrectScreen to VISIBLE, and adds one point to score if correct button pressed
         * -Sets Red and sets WrongScreen to VISIBLE if incorrect button pressed
         * -Cancels countDownTimer
         */

        choice1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                choice1.setBackgroundColor(Color.RED);
                choice2.setEnabled(false);
                choice3.setEnabled(false);
                choice4.setEnabled(false);
                wrong.setVisibility(View.VISIBLE);
                ((ActivityTwo) getActivity()).cancelTimer();
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                choice2.setBackgroundColor(Color.parseColor("#198e00"));
                choice1.setEnabled(false);
                choice3.setEnabled(false);
                choice4.setEnabled(false);
                correct.setVisibility(View.VISIBLE);
                ((ActivityTwo) getActivity()).addToScore();
                ((ActivityTwo) getActivity()).cancelTimer();
            }
        });

        choice3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                choice3.setBackgroundColor(Color.RED);
                choice2.setEnabled(false);
                choice1.setEnabled(false);
                choice4.setEnabled(false);
                wrong.setVisibility(View.VISIBLE);
                ((ActivityTwo) getActivity()).cancelTimer();
            }
        });

        choice4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                choice4.setBackgroundColor(Color.RED);
                choice2.setEnabled(false);
                choice3.setEnabled(false);
                choice1.setEnabled(false);
                wrong.setVisibility(View.VISIBLE);
                ((ActivityTwo) getActivity()).cancelTimer();
            }
        });

        return view;

    }
}
