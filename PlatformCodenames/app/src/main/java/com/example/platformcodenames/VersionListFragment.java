package com.example.platformcodenames;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.platformcodenames.databinding.FragmentVersionListBinding;

public class VersionListFragment extends Fragment {
    FragmentVersionListBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentVersionListBinding binding = FragmentVersionListBinding.inflate(inflater, container, false);
        //Dat cho danh sach hien thi theo chieu doc
        binding.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Dat Adapter cho Recycleview
        binding.recycleView.setAdapter(new VersionListAdapter(Version.versionList));
        return binding.getRoot();
    }
}