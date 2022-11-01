package com.example.secretmessage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.secretmessage.databinding.FragmentWelcomeBinding;

public class WelcomeFragment extends Fragment {
    FragmentWelcomeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        binding.startButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_welcomeFragment_to_messageFragment);
        });
        return binding.getRoot();
    }
}