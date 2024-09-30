// File: QuizFragment.java
package com.example.codesynctest;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuizFragment extends Fragment {

    private static final String TAG = "QuizFragment";
    private Button btnCheckAssessment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.activity_quiz_home, container, false);

        // Initialize the button
        btnCheckAssessment = view.findViewById(R.id.btnCheckAssessment);

        // Set click listener
        btnCheckAssessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Log the button click for debugging
                Log.d(TAG, "Check Assessment button clicked");

                // Create an explicit intent to start QuizAssessmentActivity
                Intent intent = new Intent(getActivity(), QuizAssessmentActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
