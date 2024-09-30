// File: QuizAssessmentActivity.java
package com.example.codesynctest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizAssessmentActivity extends AppCompatActivity {

    private static final String TAG = "QuizAssessmentActivity";

    private TextView quizTitle, questionText;
    private ProgressBar quizProgress;
    private RadioGroup optionsGroup;
    private RadioButton optionOne, optionTwo, optionThree, optionFour;
    private Button submitButton;
    private ImageButton prevButton, nextButton;

    // Sample data for the quiz questions and options
    private String[] questions = {
            "What is your proficiency level in data structures?",
            "What is your proficiency level in algorithms?",
            "What is your proficiency level in Java?"

    };
    private String[][] options = {
            {"Beginner", "Intermediate", "Advanced", "Expert"},
            {"Beginner", "Intermediate", "Advanced", "Expert"},
            {"Beginner", "Intermediate", "Advanced", "Expert"}
    };
    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_assessment);

        // Initialize views
        quizTitle = findViewById(R.id.quiz_title);
        questionText = findViewById(R.id.question_text);
        quizProgress = findViewById(R.id.quiz_progress);
        optionsGroup = findViewById(R.id.options_group);
        optionOne = findViewById(R.id.option_one);
        optionTwo = findViewById(R.id.option_two);
        optionThree = findViewById(R.id.option_three);
        optionFour = findViewById(R.id.option_four);
        submitButton = findViewById(R.id.submit_button);
        prevButton = findViewById(R.id.prev_button);
        nextButton = findViewById(R.id.next_button);

        // Log the start of the activity
        Log.d(TAG, "QuizAssessmentActivity started");

        // Set initial question and options
        updateQuestion();

        // Submit button click listener
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedOptionId = optionsGroup.getCheckedRadioButtonId();
                if (selectedOptionId == -1) {
                    Toast.makeText(QuizAssessmentActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton selectedOption = findViewById(selectedOptionId);
                    String answer = selectedOption.getText().toString();
                    Toast.makeText(QuizAssessmentActivity.this, "Answer submitted: " + answer, Toast.LENGTH_SHORT).show();

                    // Optionally, save the answer or proceed to the next question
                    // For this example, we'll proceed to the next question automatically
                    if (currentQuestionIndex < questions.length - 1) {
                        currentQuestionIndex++;
                        updateQuestion();
                    } else {
                        Toast.makeText(QuizAssessmentActivity.this, "Quiz Completed!", Toast.LENGTH_LONG).show();
                        // Optionally, navigate to a results screen or finish the activity
                        finish();
                    }
                }
            }
        });

        // Next button click listener
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentQuestionIndex < questions.length - 1) {
                    currentQuestionIndex++;
                    updateQuestion();
                } else {
                    Toast.makeText(QuizAssessmentActivity.this, "This is the last question", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Previous button click listener
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentQuestionIndex > 0) {
                    currentQuestionIndex--;
                    updateQuestion();
                } else {
                    Toast.makeText(QuizAssessmentActivity.this, "This is the first question", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Updates the question and options displayed in the UI.
     */
    private void updateQuestion() {
        // Set the question text
        questionText.setText(questions[currentQuestionIndex]);

        // Set the options text
        optionOne.setText(options[currentQuestionIndex][0]);
        optionTwo.setText(options[currentQuestionIndex][1]);
        optionThree.setText(options[currentQuestionIndex][2]);
        optionFour.setText(options[currentQuestionIndex][3]);

        // Update progress bar
        int progress = ((currentQuestionIndex + 1) * 100) / questions.length;
        quizProgress.setProgress(progress);

        // Clear previous selection
        optionsGroup.clearCheck();

        // Log the question update
        Log.d(TAG, "Displayed question index: " + currentQuestionIndex + ", Progress: " + progress + "%");
    }
}
