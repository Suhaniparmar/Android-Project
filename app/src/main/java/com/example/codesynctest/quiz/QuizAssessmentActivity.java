// File: QuizAssessmentActivity.java
package com.example.codesynctest.quiz;

import android.content.Intent;
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

import com.example.codesynctest.R;

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
            "What is your proficiency level in Java?",
            "What is your proficiency level in databases?",
            "What is your proficiency level in web development?"
    };
    private String[][] options = {
            {"Beginner", "Intermediate", "Advanced", "Expert"},
            {"Beginner", "Intermediate", "Advanced", "Expert"},
            {"Beginner", "Intermediate", "Advanced", "Expert"},
            {"Beginner", "Intermediate", "Advanced", "Expert"},
            {"Beginner", "Intermediate", "Advanced", "Expert"}
    };
    private int currentQuestionIndex = 0;

    // Array to store user's selected answers
    private int[] userAnswers; // Stores the selected option index for each question

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

        // Initialize userAnswers array
        userAnswers = new int[questions.length];
        for (int i = 0; i < userAnswers.length; i++) {
            userAnswers[i] = -1; // -1 indicates no selection
        }

        // Log the start of the activity
        Log.d(TAG, "QuizAssessmentActivity started");

        // Set initial question and options
        updateQuestion();

        // Submit button click listener
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Check if all questions are answered
                boolean allAnswered = true;
                for (int answer : userAnswers) {
                    if (answer == -1) {
                        allAnswered = false;
                        break;
                    }
                }

                if (!allAnswered) {
                    Toast.makeText(QuizAssessmentActivity.this, "Please answer all questions before submitting", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Calculate total score
                int totalScore = 0;
                for (int answer : userAnswers) {
                    // Assign scores: Beginner=1, Intermediate=2, Advanced=3, Expert=4
                    totalScore += (answer + 1);
                }

                Log.d(TAG, "Total Score: " + totalScore);

                // Determine eligible companies based on total score
                String[] eligibleCompanies = determineEligibleCompanies(totalScore);

                // Navigate to EligibleCompaniesActivity
                Intent intent = new Intent(QuizAssessmentActivity.this, EligibleCompaniesActivity.class);
                intent.putExtra("eligible_companies", eligibleCompanies);
                startActivity(intent);
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

        // Option selection listener to save user's answer
        optionsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedOption = -1;
                if (checkedId == R.id.option_one) {
                    selectedOption = 0;
                } else if (checkedId == R.id.option_two) {
                    selectedOption = 1;
                } else if (checkedId == R.id.option_three) {
                    selectedOption = 2;
                } else if (checkedId == R.id.option_four) {
                    selectedOption = 3;
                } else {
                    Log.w(TAG, "Unknown RadioButton checkedId: " + checkedId);
                }
                userAnswers[currentQuestionIndex] = selectedOption;
                Log.d(TAG, "Question " + currentQuestionIndex + " selected option: " + selectedOption);
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

        // Restore previous selection if any
        if (userAnswers[currentQuestionIndex] != -1) {
            if (userAnswers[currentQuestionIndex] == 0) {
                optionsGroup.check(R.id.option_one);
            } else if (userAnswers[currentQuestionIndex] == 1) {
                optionsGroup.check(R.id.option_two);
            } else if (userAnswers[currentQuestionIndex] == 2) {
                optionsGroup.check(R.id.option_three);
            } else if (userAnswers[currentQuestionIndex] == 3) {
                optionsGroup.check(R.id.option_four);
            } else {
                Log.w(TAG, "Unknown user answer index: " + userAnswers[currentQuestionIndex]);
                optionsGroup.clearCheck();
            }
        } else {
            optionsGroup.clearCheck();
        }

        // Log the question update
        Log.d(TAG, "Displayed question index: " + currentQuestionIndex + ", Progress: " + progress + "%");
    }

    /**
     * Determines eligible companies based on the total score.
     *
     * @param totalScore The total score calculated from user's answers.
     * @return An array of eligible companies.
     */
    private String[] determineEligibleCompanies(int totalScore) {
        if (totalScore <= questions.length * 1.5) { // Approximately Beginner to Intermediate
            return new String[]{"Startup A", "Company B", "Firm C"};
        } else if (totalScore <= questions.length * 2.5) { // Intermediate to Advanced
            return new String[]{"Company D", "Enterprise E", "Organization F"};
        } else { // Advanced to Expert
            return new String[]{"Global Tech G", "Innovate H", "Solutions I"};
        }
    }
}
