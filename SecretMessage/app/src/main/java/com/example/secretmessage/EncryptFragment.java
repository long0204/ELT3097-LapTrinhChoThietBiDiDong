package com.example.secretmessage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.secretmessage.databinding.FragmentEncryptBinding;

public class EncryptFragment extends Fragment {
    FragmentEncryptBinding binding;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEncryptBinding.inflate(inflater, container, false);
        String rawText = EncryptFragmentArgs.fromBundle(getArguments()).getRawText();
        String encryptedText = encrypt(rawText);
        binding.encryptedTextView.setText(encryptedText);
        return binding.getRoot();
    }
}