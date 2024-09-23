package com.example.codesynctest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultAmazon extends AppCompatActivity {

    private TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_amazon);
        textView = (TextView)findViewById(R.id.percentage);
        textView.setText("You are prepared"+ AmazonAssessmentActivity.resultInPercentage + "% for applying to Google");
    }
}