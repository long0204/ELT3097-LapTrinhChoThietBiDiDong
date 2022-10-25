package com.example.messageencrypting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.messageencrypting.databinding.ActivityConfirmBinding;

public class ConfirmActivity extends AppCompatActivity {
    private ActivityConfirmBinding binding;

    private String encrypt(String rawText) {
        StringBuilder encryptedText = new StringBuilder(rawText);
        final int NUM_OF_CHAR = ('z' - 'a' + 1);
        //Encrypt the message using Caesar Cipher: Increase each letter by one in the alphabet
        for (int i = 0; i < encryptedText.length(); i++) {
            if (encryptedText.charAt(i) >= 'a' && encryptedText.charAt(i) <= 'z') {
                encryptedText.setCharAt(i, (char) ('a' + (encryptedText.charAt(i) + 1 - 'a') % NUM_OF_CHAR));
            } else if (encryptedText.charAt(i) >= 'A' && encryptedText.charAt(i) <= 'Z') {
                encryptedText.setCharAt(i, (char) ('A' + (encryptedText.charAt(i) + 1 - 'A') % NUM_OF_CHAR));
            } else if (encryptedText.charAt(i) >= '0' && encryptedText.charAt(i) <= '9')
                encryptedText.setCharAt(i, (char) ('0' + (encryptedText.charAt(i) + 1 - '0') % 10));
        }
        return encryptedText.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        binding.confirmEmailEditText.setText(intent.getStringExtra(MainActivity.EMAIL_KEY));
        binding.confirmSubjectEditText.setText(intent.getStringExtra(MainActivity.SUBJECT_KEY));
        String encryptedMessage = encrypt(intent.getStringExtra(MainActivity.UNENCRYPTED_MESSAGE_KEY));
        binding.encryptedMessageEditText.setText(encryptedMessage);

        binding.sendButton.setOnClickListener(view -> {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("*/*");
            sendIntent.putExtra(Intent.EXTRA_EMAIL, binding.confirmEmailEditText.getText().toString());
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, binding.confirmSubjectEditText.getText().toString());
            sendIntent.putExtra(Intent.EXTRA_TEXT, binding.encryptedMessageEditText.getText().toString());
            startActivity(Intent.createChooser(sendIntent, null));
        });
    }
}