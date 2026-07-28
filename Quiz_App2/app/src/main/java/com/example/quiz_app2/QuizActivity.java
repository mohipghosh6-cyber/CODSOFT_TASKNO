package com.example.quiz_app2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    TextView txtQuestion;
    Button btnOption1, btnOption2, btnOption3, btnOption4, btnNext;

    int currentQuestion = 0;
    int score = 0;
    boolean answered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        txtQuestion = findViewById(R.id.txtQuestion);
        btnOption1 = findViewById(R.id.btnOption1);
        btnOption2 = findViewById(R.id.btnOption2);
        btnOption3 = findViewById(R.id.btnOption3);
        btnOption4 = findViewById(R.id.btnOption4);
        btnNext = findViewById(R.id.btnNext);

        loadQuestion();

        btnOption1.setOnClickListener(v -> checkAnswer(0));
        btnOption2.setOnClickListener(v -> checkAnswer(1));
        btnOption3.setOnClickListener(v -> checkAnswer(2));
        btnOption4.setOnClickListener(v -> checkAnswer(3));

        btnNext.setOnClickListener(v -> {

            currentQuestion++;

            if (currentQuestion < QuizData.questions.length) {
                loadQuestion();
            } else {
                Toast.makeText(
                        this,
                        "Quiz Finished!\nScore: " + score + "/" + QuizData.questions.length,
                        Toast.LENGTH_LONG
                ).show();

                finish();
            }
        });
    }

    private void loadQuestion() {
        answered = false;
        txtQuestion.setText(QuizData.questions[currentQuestion]);

        btnOption1.setText(QuizData.options[currentQuestion][0]);
        btnOption2.setText(QuizData.options[currentQuestion][1]);
        btnOption3.setText(QuizData.options[currentQuestion][2]);
        btnOption4.setText(QuizData.options[currentQuestion][3]);
    }

    private void checkAnswer(int selectedAnswer) {

        if (answered) {
            return;
        }

        answered = true;

        if (selectedAnswer == QuizData.answers[currentQuestion]) {
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }
    }
}