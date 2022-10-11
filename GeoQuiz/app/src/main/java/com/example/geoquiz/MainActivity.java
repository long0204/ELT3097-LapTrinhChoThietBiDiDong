package com.example.geoquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.geoquiz.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String QUESTION_INDEX_KEY = "QUESTION_INDEX_KEY";

    private static final List<Question> questions = new ArrayList<>(Arrays.asList(
            new Question("1. Ha Noi la thu do cua Viet Nam?", true),
            new Question("2. Ha Noi la thanh pho lon nhat cua Viet Nam?", false),
            new Question("3. TP. Ho Chi Minh la thanh pho dong dan nhat cua Viet Nam?", true)
    ));

    private ActivityMainBinding binding;
    private int questionIndex;

    private void showResponse(Boolean userAnswer) {
        if (questions.get(questionIndex).getQuestionAnswer() == userAnswer)
            Snackbar.make(binding.getRoot(), R.string.correct_answer_response, Snackbar.LENGTH_SHORT).show();
        else
            Snackbar.make(binding.getRoot(), R.string.incorrect_answer_response, Snackbar.LENGTH_SHORT).show();
    }

    private void updateQuestionText() {
        binding.questionTextView.setText(questions.get(questionIndex).getQuestionText());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        questionIndex = (savedInstanceState != null) ? savedInstanceState.getInt(QUESTION_INDEX_KEY) : 0;

        updateQuestionText();

        binding.answerTrueButton.setOnClickListener(view -> showResponse(true));

        binding.answerFalseButton.setOnClickListener(view -> showResponse(false));

        binding.nextButton.setOnClickListener(view -> {
            if (questionIndex + 1 < questions.size()) {
                questionIndex += 1;
                updateQuestionText();
            }
        });

        binding.prevButton.setOnClickListener(view -> {
            if (questionIndex - 1 >= 0) {
                questionIndex -= 1;
                updateQuestionText();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(QUESTION_INDEX_KEY, questionIndex);
    }
}