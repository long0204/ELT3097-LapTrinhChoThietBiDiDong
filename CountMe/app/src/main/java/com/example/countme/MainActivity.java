package com.example.countme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String COUNT_KEY = "COUNT_KEY";
    private Button countButton;
    private TextView countTextView;
    private int count;

    private String getPhrase() {
        if (count == 0)
            return "Nothing to show";
        else if (count == 1)
            return "You've pressed " + count + " time";
        else
            return "You've pressed " + count + " times";
    }

    private void updateText() {
        if (countTextView == null)
            throw new NullPointerException();
        else
            countTextView.setText(getPhrase());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null)
            count = savedInstanceState.getInt(COUNT_KEY, 0);
        else
            count = 0;

        countButton = findViewById(R.id.count_button);
        countTextView = findViewById(R.id.count_text_view);

        updateText();

        countButton.setOnClickListener(view -> {
            count += 1;
            countTextView.setText(getPhrase());
        });

        countButton.setOnLongClickListener(view -> {
            count = 0;
            updateText();
            return true;
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT_KEY, count);
    }
}