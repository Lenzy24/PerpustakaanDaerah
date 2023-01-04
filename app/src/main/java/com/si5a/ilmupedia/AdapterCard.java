package com.si5a.ilmupedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.ClassViewHolder> {
    private ArrayList<ModelPerpustakaan> dataPerpustakaan;
    private Context ctx;


    public AdapterCard(ArrayList<ModelPerpustakaan> dataPerpustakaan, Context ctx){
        this.dataPerpustakaan = dataPerpustakaan;
        this.ctx = ctx;
    }



    @NonNull
    @Override
    public AdapterCard.ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.item_card, parent, false);
        return new ClassViewHolder(varView);
    }



    //    untuk menentukan posisi
    @Override
    public void onBindViewHolder(@NonNull AdapterCard.ClassViewHolder holder, int position) {
        ModelPerpustakaan perpustakaan = dataPerpustakaan.get(position);
        holder.tv_nama.setText(perpustakaan.getNama());
        holder.tv_tentang.setText(perpustakaan.getTentang());
        Glide
                .with(ctx)
                .load(perpustakaan.getFoto())
                .centerCrop()
                .into(holder.iv_foto);

    }

    @Override
    public int getItemCount() {
        return dataPerpustakaan.size();
    }

    public class ClassViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama, tv_tentang;
        ImageView iv_foto;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_nama);
            tv_tentang = itemView.findViewById(R.id.tv_tentang);
            iv_foto = itemView.findViewById(R.id.iv_foto);
        }
    }
}