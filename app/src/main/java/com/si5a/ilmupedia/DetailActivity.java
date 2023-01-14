package com.si5a.ilmupedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import android.content.Intent;



public class DetailActivity extends AppCompatActivity {

    private ImageView ivfoto;
    private TextView tvnama, tvtentang;
    private String ynama, ytentang, yfoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivfoto = findViewById(R.id.iv_foto);
        tvnama = findViewById(R.id.tv_nama);
        tvtentang = findViewById(R.id.tv_tentang);

        Intent terima = getIntent();
        ynama = terima.getStringExtra("xnama");
        ytentang = terima.getStringExtra("xtentang");
        yfoto = terima.getStringExtra("xfoto");

        tvnama.setText(ynama);
        tvtentang.setText(ytentang);
        Glide
                .with(DetailActivity.this)
                .load(yfoto)
                .into(ivfoto);

    }

}
