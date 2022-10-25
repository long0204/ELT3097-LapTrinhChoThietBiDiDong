package com.example.messageencrypting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.messageencrypting.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    public static final String EMAIL_KEY = "PHONE_KEY";
    public static final String SUBJECT_KEY = "SUBJECT_KEY";
    public static final String UNENCRYPTED_MESSAGE_KEY = "UNENCRYPTED_MESSAGE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.encryptButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, ConfirmActivity.class);
            intent.putExtra(EMAIL_KEY, binding.emailEditText.getText().toString());
            intent.putExtra(SUBJECT_KEY, binding.subjectEditText.getText().toString());
            intent.putExtra(UNENCRYPTED_MESSAGE_KEY, binding.messageEditText.getText().toString());

            startActivity(intent);
        });
    }
}