package com.example.secretmessage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.secretmessage.databinding.FragmentMessageBinding;

public class MessageFragment extends Fragment {
    FragmentMessageBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMessageBinding.inflate(inflater, container, false);
        binding.nextButton.setOnClickListener(view -> {
            String rawText = binding.userInputEditText.getText().toString();
            MessageFragmentDirections.ActionMessageFragmentToEncryptFragment action = MessageFragmentDirections.actionMessageFragmentToEncryptFragment(rawText);
            Navigation.findNavController(view).navigate(action);
        });
        return binding.getRoot();
    }
}