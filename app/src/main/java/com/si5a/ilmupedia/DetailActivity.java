package com.si5a.ilmupedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import android.content.Intent;



public class DetailActivity extends AppCompatActivity {

    private ImageView ivFoto;
    private TextView tvnama, tvTentang;
    private String yNama, ytentang, yFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivFoto = findViewById(R.id.iv_foto);
        tvnama = findViewById(R.id.tv_nama);
        tvTentang = findViewById(R.id.tv_tentang);

        Intent terima = getIntent();
        yNama = terima.getStringExtra("xNama");
        ytentang = terima.getStringExtra("xTentang");
        yFoto = terima.getStringExtra("xFoto");

        tvnama.setText(yNama);
        tvTentang.setText(ytentang);
        Glide
                .with(DetailActivity.this)
                .load(yFoto)
                .into(ivFoto);

    }

}
