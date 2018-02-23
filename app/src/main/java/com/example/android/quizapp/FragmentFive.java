package com.example.android.quizapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FragmentFive extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment_five, container, false);

        Button submit = view.findViewById(R.id.submit_answer);
        final TextView correct = getActivity().findViewById(R.id.correct);
        final TextView wrong = getActivity().findViewById(R.id.wrong);


        /*
         * OnClickListener for submit Button
         *
         * On click :
         * -If EditText input = "2", correctScreen VISIBLE, add one point to score
         * -Else, wrongScreen VISIBLE
         * -Cancel Timer
         */

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText editText = getActivity().findViewById(R.id.input1);
                final String userInput = editText.getText().toString();
                if (userInput.equals("2")) {
                    correct.setVisibility(View.VISIBLE);
                    ((ActivityTwo) getActivity()).addToScore();  //Add a point to final score
                    ((ActivityTwo) getActivity()).cancelTimer();  //Cancel CountDownTimer
                } else {
                    wrong.setVisibility(View.VISIBLE);
                    ((ActivityTwo) getActivity()).cancelTimer();  //Cancel CountDownTimer
                }

            }

        });

        return view;

    }
}
