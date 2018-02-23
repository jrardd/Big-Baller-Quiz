package com.example.android.quizapp;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FragmentSeven extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment_seven, container, false);

        final TextView correct = getActivity().findViewById(R.id.correct);
        final TextView wrong = getActivity().findViewById(R.id.wrong);
        final Button submit = view.findViewById(R.id.submit_answer2);
        final Button choice1 = view.findViewById(R.id.c1);
        final Button choice2 = view.findViewById(R.id.c2);
        final Button choice3 = view.findViewById(R.id.c3);
        final Button choice4 = view.findViewById(R.id.c4);

        /*
         * OnClickListeners for each button (Imitates CheckBox function for multiple choices)
         *
         * On click :
         * -Adds Highlight color of #FFFFFF to determine if clicked or not, makes button lighter (Selected)
         * -If clicked again after assigning, switches HighlightColor to #EEEEEE, makes button darker (Unselected)
         */

        choice1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (choice1.getHighlightColor() != Color.parseColor("#FFFFFF")) {
                    choice1.setBackgroundColor(Color.parseColor("#888888"));
                    choice1.setHighlightColor(Color.parseColor("#FFFFFF"));
                } else {
                    choice1.setBackgroundColor(Color.parseColor("#597e7e7e"));
                    choice1.setHighlightColor(Color.parseColor("#EEEEEE"));
                }
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (choice2.getHighlightColor() != Color.parseColor("#FFFFFF")) {
                    choice2.setBackgroundColor(Color.parseColor("#888888"));
                    choice2.setHighlightColor(Color.parseColor("#FFFFFF"));
                } else {
                    choice2.setBackgroundColor(Color.parseColor("#597e7e7e"));
                    choice2.setHighlightColor(Color.parseColor("#EEEEEE"));
                }
            }
        });

        choice3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (choice3.getHighlightColor() != Color.parseColor("#FFFFFF")) {
                    choice3.setBackgroundColor(Color.parseColor("#888888"));
                    choice3.setHighlightColor(Color.parseColor("#FFFFFF"));
                } else {
                    choice3.setBackgroundColor(Color.parseColor("#597e7e7e"));
                    choice3.setHighlightColor(Color.parseColor("#EEEEEE"));
                }
            }
        });

        choice4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (choice4.getHighlightColor() != Color.parseColor("#FFFFFF")) {
                    choice4.setBackgroundColor(Color.parseColor("#888888"));
                    choice4.setHighlightColor(Color.parseColor("#FFFFFF"));
                } else {
                    choice4.setBackgroundColor(Color.parseColor("#597e7e7e"));
                    choice4.setHighlightColor(Color.parseColor("#EEEEEE"));
                }
            }
        });

        /*
         * OnClickListener for submit Button
         *
         * On click :
         * -If correct answers are selected, (determined by HighlightColor assigned), correctScreen VISIBLE
         * -Else, wrongScreen VISIBLE
         * -Cancel Timer
         */

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if (choice4.getHighlightColor() != Color.parseColor("#FFFFFF") &&
                        choice1.getHighlightColor() == Color.parseColor("#FFFFFF") &&
                        choice2.getHighlightColor() == Color.parseColor("#FFFFFF") &&
                        choice3.getHighlightColor() == Color.parseColor("#FFFFFF")) {

                    correct.setVisibility(View.VISIBLE);
                    ((ActivityTwo) getActivity()).addToScore();
                    ((ActivityTwo) getActivity()).cancelTimer();

                } else {
                    wrong.setVisibility(View.VISIBLE);
                    ((ActivityTwo) getActivity()).cancelTimer();
                }

            }

        });


        return view;

    }
}
