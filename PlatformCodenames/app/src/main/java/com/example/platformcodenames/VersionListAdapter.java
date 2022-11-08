package com.example.platformcodenames;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.platformcodenames.databinding.VersionItemBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class VersionListAdapter extends RecyclerView.Adapter<VersionListAdapter.VersionViewHolder> {
    public static class VersionViewHolder extends RecyclerView.ViewHolder {
        VersionItemBinding binding;

        public VersionViewHolder(VersionItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        //Ham bind() nhan mot bien item va dat gia tri cua cac bien
        public void bind(Version item) {
            binding.nameTextView.setText(item.getName());
            binding.numberTextView.setText(Double.toString(item.getNumber()));

            //Them hanh dong khi nhan vao cac item
            binding.getRoot().setOnClickListener(view -> {
                Snackbar.make(view.getRootView().findViewById(R.id.nav_host_fragment), item.getName() + " " + item.getNumber(), Toast.LENGTH_SHORT).show();
            });
        }
    }

    //versionList chua cac phan tu can hien thi trong danh sach
    private final ArrayList<Version> versionList;

    public VersionListAdapter(ArrayList<Version> versionList) {
        this.versionList = versionList;
    }

    /*
    onCreateViewHolder tao ra cac ViewHolder, chinh la cac item trong danh sach
    so item duoc tao ra la so item vua du de hien thi tren man hinh
    neu danh sach dai hon man hinh, khi cac muc duoc keo ra khoi man hinh no se
    duoc tai su dung cho item phia duoi.
    */
    @NonNull
    @Override
    public VersionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        VersionItemBinding binding = VersionItemBinding.inflate(inflater, parent, false);
        return new VersionViewHolder(binding);
    }

    /*
    onBindViewHolder() nhan vao bien holder la mot item/view holder la mot item can duoc dien noi dung
    bien position la vi tri cua item muon hien thi trong danh sach
    Goi ham bind cua class VersionViewHolder vua tao de dien noi dung cho item do.
     */
    @Override
    public void onBindViewHolder(@NonNull VersionViewHolder holder, int position) {
        holder.bind(versionList.get(position));
    }

    /*
    getItemCount() tra ve so luong phan tu trong danh sach
     */
    @Override
    public int getItemCount() {
        return versionList.size();
    }
}
