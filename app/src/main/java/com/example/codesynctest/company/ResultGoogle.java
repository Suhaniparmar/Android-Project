package com.example.codesynctest.company;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.codesynctest.R;

public class ResultGoogle extends AppCompatActivity {

    private TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_google);
         textView = (TextView)findViewById(R.id.percentage);
         textView.setText("You are prepared"+ GoogleAssessmentActivity.resultInPercentage + "% for applying to Google");
    }
}